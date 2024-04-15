package theatre.dto;

import org.springframework.stereotype.Component;

@Component
public class VenueDTO {

    private long id;
    private String venueDescription;

    public VenueDTO(long id, String venueDescription) {
        this.id = id;
        this.venueDescription = venueDescription;
    }

    public VenueDTO() {
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
    public void setVenueDescription(String venueDescription) {
        this.venueDescription = venueDescription;
    }

}
