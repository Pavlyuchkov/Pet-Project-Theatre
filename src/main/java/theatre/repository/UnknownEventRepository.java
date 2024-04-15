package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import theatre.model.UnknownEvent;

public interface UnknownEventRepository extends JpaRepository<UnknownEvent, Long> {

    boolean existsByTitleAndVenueDescription(String title, String venueDescription);
}
