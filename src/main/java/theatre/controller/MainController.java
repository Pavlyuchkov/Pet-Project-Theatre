package theatre.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theatre.dto.EventNameDTO;
import theatre.dto.SavedFilterDTO;
import theatre.dto.VenueDTO;
import theatre.service.EventParser;
import theatre.util.EventNotFoundException;
import theatre.util.SavedFilterErrorResponse;
import theatre.util.SavedFilterResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/app")
public class MainController {

    private final EventParser eventParser;

    public MainController(EventParser eventParser) {
        this.eventParser = eventParser;
    }

    @GetMapping("/venues")
    public List<VenueDTO> getAllVenues() {
        return eventParser.findAll();
    }

    @GetMapping("/venues/{id}")
    public List<EventNameDTO> getVenue(@PathVariable("id") long id) {
        return eventParser.findByVenueId(id);
    }

    @PostMapping("/save_event")
    public ResponseEntity<String> create(@RequestBody SavedFilterDTO savedFilterDTO) {
        eventParser.testSaveUserFilterFromPostman(savedFilterDTO);
        SavedFilterResponseEntity savedFilterResponseEntity = new SavedFilterResponseEntity();
        String message200 = savedFilterResponseEntity.message200();
        return ResponseEntity.ok(message200);
    }

    @ExceptionHandler(EventNotFoundException.class)
    private ResponseEntity<String> handleNotFound() {
        SavedFilterErrorResponse savedFilterErrorResponse = new SavedFilterErrorResponse();
        String message404 = savedFilterErrorResponse.message404();
        return ResponseEntity.ofNullable(message404);
    }
}
