package theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theatre.model.SavedFilter;

import java.util.List;

@Repository
public interface SavedFilterRepository extends JpaRepository<SavedFilter, Long> {

    List<SavedFilter> findByEventNameId(long event_name_id);
    boolean existsByEventNameIdAndChatId(long event_name_id, long chat_id);
}
