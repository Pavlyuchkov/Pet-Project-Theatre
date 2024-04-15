package theatre.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import theatre.model.VenueDirectory;
import theatre.repository.VenueDirectoryRepository;
import static org.mockito.Mockito.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class VenueCacheTest {

    @SpyBean
    private final VenueDirectoryRepository venueDirectoryRepository;
    private final CacheService cacheService;

    @Autowired
    public VenueCacheTest(CacheService cacheService, VenueDirectoryRepository venueDirectoryRepository) {
        this.venueDirectoryRepository = venueDirectoryRepository;
        this.cacheService = cacheService;
    }

    @Test
    public void testFindVenueById() {
        final long id = 69L;

        VenueDirectory venueDirectory = cacheService.findVenueById(id);
        Assertions.assertNotNull(venueDirectory, "Theatre is not found");

        VenueDirectory cachedVenue = cacheService.findVenueById(id);
        Assertions.assertNotNull(cachedVenue, "Theatre is not found");

        verify(venueDirectoryRepository, times(1)).findById(id);
    }
}