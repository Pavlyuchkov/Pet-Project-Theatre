package theatre.service;

import org.springframework.stereotype.Service;
import theatre.dto.*;
import theatre.model.*;
import theatre.repository.*;
import theatre.telegram.TelegramBot;
import theatre.util.EventNotFoundException;
import theatre.util.SourceType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class EventParser {

    private final KvitkiWebClient kvitkiWebClient;
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final VenueDirectoryRepository venueDirectoryRepository;
    private final SavedFilterRepository savedFilterRepository;
    private final EventNameDirectoryRepository eventNameDirectoryRepository;
    private final EventNameRepository eventNameRepository;
    private final TelegramBot telegramBot;
    private final UnknownEventRepository unknownEventRepository;

    public EventParser(KvitkiWebClient kvitkiWebClient, EventRepository eventRepository, VenueRepository venueRepository, VenueDirectoryRepository venueDirectoryRepository, SavedFilterRepository savedFilterRepository, EventNameDirectoryRepository eventNameDirectoryRepository, EventNameRepository eventNameRepository, TelegramBot telegramBot, UnknownEventRepository unknownEventRepository) {
        this.kvitkiWebClient = kvitkiWebClient;
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.venueDirectoryRepository = venueDirectoryRepository;
        this.savedFilterRepository = savedFilterRepository;
        this.eventNameDirectoryRepository = eventNameDirectoryRepository;
        this.eventNameRepository = eventNameRepository;
        this.telegramBot = telegramBot;
        this.unknownEventRepository = unknownEventRepository;
    }

    public void processing() {
        List<EventDTO> events = kvitkiWebClient.getEvents();
        for (EventDTO eventDTO : events) {
            saveEvent(eventDTO);
        }
        System.out.println();
    }

    public void saveEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setEventId(eventDTO.getId());
        event.setTitle(eventDTO.getTitle());
        event.setPromoterId(eventDTO.getPromoterId());
        event.setMinPrice(eventDTO.getMinPrice());
        event.setShortUrl(eventDTO.getShortUrl());
        event.setShortImageUrl(eventDTO.getShortImageUrl());
        event.setSpecialStatus(eventDTO.getSpecialStatus());
        event.setSalesStatus(eventDTO.getSalesStatus());
        event.setLocalisedStartDate(splitStartDate(eventDTO));
        event.setLocalisedEndDate(splitEndDate(eventDTO));
        event.setPrices(eventDTO.getPrices());
        event.setType(eventDTO.getType());
        event.setSalestart(eventDTO.getSalestart());
        event.setSource(SourceType.kvitki);

        Optional<Event> existingEvent = eventRepository.findByEventIdAndSource(eventDTO.getId(), SourceType.kvitki);
        if (existingEvent.isPresent()) {
            Event event1 = existingEvent.get();
            if (!event1.getSalesStatus().equals(eventDTO.getSalesStatus()) && !eventDTO.getSalesStatus().equals("sold_out")) {
                event1.setSalesStatus(eventDTO.getSalesStatus());
                telegramBot.checkAndSendPresaleNotifications(event1);
                eventRepository.save(event1);
            }
        }
        else {
            Optional<VenueDirectory> venueDirectory = venueDirectoryRepository.findByVenueDescription(eventDTO.getVenueDescription());
            if (venueDirectory.isPresent()) {
                event.setVenue(venueDirectory.get().getVenue());
                Optional<EventNameDirectory> eventNameDirectory =
                        eventNameDirectoryRepository.findByTitle(eventDTO.getTitle()).stream().findFirst();
                if (eventNameDirectory.isPresent()) {
                    event.setEventName(eventNameDirectory.get().getEventName());
                    eventRepository.save(event);
                    System.out.println();
                } else {
                    saveUnknownEvent(eventDTO);
                }
            } else {
                saveUnknownEvent(eventDTO);
            }
        }
    }

    public void saveUnknownEvent(EventDTO eventDTO) {
        if (!unknownEventRepository.existsByTitleAndVenueDescription(eventDTO.getTitle(), eventDTO.getVenueDescription())) {
            UnknownEvent unknownEvent = new UnknownEvent();
            unknownEvent.setTitle(eventDTO.getTitle());
            unknownEvent.setVenueDescription(eventDTO.getVenueDescription());
            unknownEvent.setEventId(eventDTO.getId());
            unknownEventRepository.save(unknownEvent);
        }
    }

    public LocalDate splitStartDate(EventDTO eventDTO) {
        String getDTO = eventDTO.getLocalisedStartDate();
        String[] split = getDTO.split(" ", 2);
        String startDate = split[1];
        return LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public LocalDate splitEndDate(EventDTO eventDTO) {
        String getDTO = eventDTO.getLocalisedEndDate();
        String[] split = getDTO.split(" ", 2);
        String endDate = split[1];
        return LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public List<VenueDTO> findAll() {
        return venueRepository.findAll().stream()
                .map(venue -> {
                    VenueDTO venueDTO = new VenueDTO();
                    venueDTO.setId(venue.getId());
                    venueDTO.setVenueDescription(venue.getVenueDescription());
                    return venueDTO;
                })
                .toList();
    }

    public List<EventNameDTO> findByVenueId(long id) {
        return eventNameRepository.findByVenueId(id).stream()
                .map(eventName -> {
                    EventNameDTO eventNameDTO = new EventNameDTO();
                    eventNameDTO.setId(eventName.getId());
                    eventNameDTO.setTitle(eventName.getTitle());
                    return eventNameDTO;
                })
                .toList();
    }

    public void testSaveUserFilterFromPostman(SavedFilterDTO savedFilterDTO) {
        SavedFilter savedFilter = new SavedFilter();
        savedFilter.setChatId(savedFilterDTO.getchatId());
        EventName eventName = eventNameRepository.findById(savedFilterDTO.getEventNameId())
                .orElseThrow(EventNotFoundException::new);
        savedFilter.setEventName(eventName);
        savedFilterRepository.save(savedFilter);
    }
}






