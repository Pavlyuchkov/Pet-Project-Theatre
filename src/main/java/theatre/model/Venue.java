package theatre.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "venue_table")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String venueDescription;

    @OneToMany(mappedBy = "venue")
    private List<Event> eventList;

    @OneToMany(mappedBy = "venue")
    private List<VenueDirectory> venueDirectoryList;

    @OneToMany(mappedBy = "venue")
    private List<EventName> eventNameList;

    public Venue() {}

    @Override
    public String toString() {
        return venueDescription;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getVenueDescription() {
        return venueDescription;
    }
}
