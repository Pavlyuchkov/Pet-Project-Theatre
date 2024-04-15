package theatre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import theatre.model.VenueDirectory;
import theatre.repository.VenueDirectoryRepository;

import java.util.Optional;

@Service
public class CacheService {

    private final VenueDirectoryRepository venueDirectoryRepository;

    @Autowired
    public CacheService(VenueDirectoryRepository venueDirectoryRepository) {
        this.venueDirectoryRepository = venueDirectoryRepository;
    }

    @Cacheable(value = "CacheVenue", unless = "#result == null")
    public VenueDirectory findVenueById(long id) {
        Optional<VenueDirectory> venueOptional = venueDirectoryRepository.findById(id);
        return venueOptional.orElse(null);
    }
}
