package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import theatre.model.Venue;
import theatre.model.VenueDirectory;

import java.util.Optional;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}