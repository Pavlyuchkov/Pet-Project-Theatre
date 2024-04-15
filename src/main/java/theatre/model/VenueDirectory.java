package theatre.model;

import jakarta.persistence.*;

@Entity
@Table(name = "venue_directory_table")
public class VenueDirectory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "venue_description")
    private String venueDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    public VenueDirectory() {}

    public Venue getVenue() {
        return venue;
    }
}