package theatre.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import theatre.util.SourceType;
import java.time.LocalDate;

@Entity
@Table(name = "event_table")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long eventId;
    private String title;
    private long promoterId;
    private long minPrice;
    private String shortUrl;
    private String shortImageUrl;
    private String specialStatus;
    private String salesStatus;
    private String prices;
    private String type;
    private String salestart;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate localisedStartDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate localisedEndDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "event_name_id")
    private EventName eventName;

    @Enumerated(EnumType.STRING)
    private SourceType source;

    public Event() {}

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPromoterId(long promoterId) {
        this.promoterId = promoterId;
    }
    public void setMinPrice(long minPrice) {
        this.minPrice = minPrice;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
    public void setShortImageUrl(String shortImageUrl) {
        this.shortImageUrl = shortImageUrl;
    }
    public void setSpecialStatus(String specialStatus) {
        this.specialStatus = specialStatus;
    }
    public String getSalesStatus() {return salesStatus;}
    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }
    public void setPrices(String prices) {
        this.prices = prices;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setSalestart(String salestart) {
        this.salestart = salestart;
    }
    public void setLocalisedStartDate(LocalDate localisedStartDate) {
        this.localisedStartDate = localisedStartDate;
    }
    public void setLocalisedEndDate(LocalDate localisedEndDate) {
        this.localisedEndDate = localisedEndDate;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    public void setSource(SourceType source) {
        this.source = source;
    }
    public EventName getEventName() {
        return eventName;
    }
    public void setEventName(EventName eventName) {
        this.eventName = eventName;
    }
}