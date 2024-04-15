package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theatre.model.Event;
import theatre.model.EventName;

import java.util.List;

@Repository
public interface EventNameRepository extends JpaRepository<EventName, Long> {

    List<EventName> findByVenueId(long id);
}