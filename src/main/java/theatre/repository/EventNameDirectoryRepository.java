package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theatre.model.EventNameDirectory;
import theatre.model.VenueDirectory;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventNameDirectoryRepository extends JpaRepository<EventNameDirectory, Long> {

    List<EventNameDirectory> findByTitle(String title);
}