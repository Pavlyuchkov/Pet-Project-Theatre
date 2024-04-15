package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theatre.model.VenueDirectory;

import java.util.Optional;

@Repository
public interface VenueDirectoryRepository extends JpaRepository<VenueDirectory, Long> {

    Optional<VenueDirectory> findByVenueDescription(String venueDescription);
}
