package theatre.telegram;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import theatre.config.BotConfig;
import theatre.repository.EventNameRepository;
import theatre.repository.SavedFilterRepository;

@Component
public class BotInitializer {

    private final EventNameRepository eventNameRepository;
    private final BotConfig botConfig;
    private final SavedFilterRepository savedFilterRepository;

    public BotInitializer(EventNameRepository eventNameRepository, BotConfig botConfig, SavedFilterRepository savedFilterRepository) {
        this.eventNameRepository = eventNameRepository;
        this.botConfig = botConfig;
        this.savedFilterRepository = savedFilterRepository;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void initBot() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TelegramBot(botConfig, eventNameRepository, savedFilterRepository));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}