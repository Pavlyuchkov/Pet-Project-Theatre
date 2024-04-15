package theatre.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import theatre.service.EventParser;

@Component
public class EventScheduler {

   private final EventParser eventParser;

    public EventScheduler(EventParser eventParser) {
        this.eventParser = eventParser;
    }

    @Scheduled(fixedDelay = 60000L)
    public void schedule(){
        eventParser.processing();
    }
}