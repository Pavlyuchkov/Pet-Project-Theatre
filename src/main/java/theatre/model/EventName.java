package theatre.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "event_name")
public class EventName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @OneToMany(mappedBy = "eventName")
    private List<EventNameDirectory> eventNameDirectoryList;

    @OneToMany(mappedBy = "eventName")
    private List<Event> eventList;

    @OneToMany(mappedBy = "eventName")
    private List<SavedFilter> savedFilterList;

    @OneToMany(mappedBy = "title")
    private List<SavedFilter> savedFilterList1;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    public EventName() {}

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
}
