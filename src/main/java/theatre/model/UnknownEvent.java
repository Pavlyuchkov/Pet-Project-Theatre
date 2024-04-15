package theatre.model;

import jakarta.persistence.*;

@Entity
@Table(name = "unknown_new_events")
public class UnknownEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String venueDescription;
    private long venueId;
    private Long eventId;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }
    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
}
