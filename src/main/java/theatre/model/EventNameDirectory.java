package theatre.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_name_directory")
public class EventNameDirectory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private long eventId;

    @ManyToOne
    @JoinColumn(name = "event_name_id")
    private EventName eventName;

    public EventNameDirectory() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public EventName getEventName() {
        return eventName;
    }
}
