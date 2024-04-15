package theatre.telegram;

import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import theatre.config.BotConfig;
import theatre.model.Event;
import theatre.model.EventName;
import theatre.model.SavedFilter;
import theatre.repository.EventNameRepository;
import theatre.repository.SavedFilterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static theatre.telegram.BotCommands.LIST_OF_COMMANDS;

@Service
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final EventNameRepository eventNameRepository;
    private final SavedFilterRepository savedFilterRepository;

    public TelegramBot(BotConfig botConfig, EventNameRepository eventNameRepository, SavedFilterRepository savedFilterRepository) {
        this.botConfig = botConfig;
        this.eventNameRepository = eventNameRepository;
        this.savedFilterRepository = savedFilterRepository;
        try {
            this.execute(new SetMyCommands(LIST_OF_COMMANDS, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(@NotNull Update update) {
        long chatId;
        String userName;
        String receivedMessage;
        long messageId;

        if(update.hasMessage()) {
            chatId = update.getMessage().getChatId();
            userName = update.getMessage().getFrom().getFirstName();
            messageId = update.getMessage().getMessageId();
            if (update.getMessage().hasText()) {
                receivedMessage = update.getMessage().getText();
                botAnswerUtils(receivedMessage, chatId, userName, messageId);
            }
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            userName = update.getCallbackQuery().getFrom().getFirstName();
            receivedMessage = update.getCallbackQuery().getData();
            messageId = update.getCallbackQuery().getMessage().getMessageId();

            botAnswerUtils(receivedMessage, chatId, userName, messageId);
        }
    }

    private void botAnswerUtils(String receivedMessage, long chatId, String userName, long messageId) {
        switch (receivedMessage) {
            case "/start":
                startBot(chatId, userName);
                break;
            case "/help":
                sendHelpText(chatId, messageId);
                break;
            case "/choose":
                showRegions(chatId);
                break;
            case "Minsk":
                showMinskTheatres(chatId, messageId);
                break;
            case "Brest":
                showBrestTheatres(chatId, messageId);
                break;
            case "Vitebsk":
                showVitebskTheatres(chatId, messageId);
                break;
            case "Gomel":
                showGomelTheatres(chatId, messageId);
                break;
            case "Grodno":
                showGrodnoTheatres(chatId, messageId);
                break;
            case "Mogilev":
                showMogilevTheatres(chatId, messageId);
                break;
            case "Other":
                showOtherTheatres(chatId, messageId);
                break;
            case "YesButton":
                yesButton(chatId, userName, messageId);
                break;
            case "NoButton":
                noButton(chatId, userName, messageId);
                break;
            case "TryButton":
                tryButton(chatId, messageId);
                break;
            default:
                theatreAndEventsLogic(receivedMessage, chatId, userName, messageId);
                break;
        }
    }

    private void startBot(long chatId, String userName) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Привет, " + userName + "! Рад тебя видеть! Если ты тут впервые - нажимай на кнопку 'Помощь', и я объясню, чем я могу быть полезен!");
        message.setReplyMarkup(Buttons.inlineMarkupStartHelp());
        sendMessage(message);
    }

    private void sendHelpText(long chatId, long messageId){
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText(BotCommands.HELP_TEXT);
        message.setMessageId((int) messageId);
        message.setReplyMarkup(Buttons.tryMarkup());
        editMessage(message);
    }

    private void showRegions(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Сначала выбери свой город:");
        message.setReplyMarkup(Buttons.inlineMarkUpRegions());
        sendMessage(message);
    }

    private void showMinskTheatres(long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Теперь выбери театр из спика ниже:");
        message.setReplyMarkup(Buttons.MinskTheatres());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    private void showBrestTheatres(long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Теперь выбери театр из спика ниже:");
        message.setReplyMarkup(Buttons.BrestTheatres());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    private void showVitebskTheatres(long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Теперь выбери театр из спика ниже:");
        message.setReplyMarkup(Buttons.VitebskTheatres());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    private void showGomelTheatres(long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Теперь выбери театр из спика ниже:");
        message.setReplyMarkup(Buttons.GomelTheatres());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    private void showGrodnoTheatres(long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Теперь выбери театр из спика ниже:");
        message.setReplyMarkup(Buttons.GrodnoTheatres());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    private void showMogilevTheatres(long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Теперь выбери театр из спика ниже:");
        message.setReplyMarkup(Buttons.MogilevTheatres());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    private void showOtherTheatres(long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Теперь выбери театр из спика ниже:");
        message.setReplyMarkup(Buttons.OtherTheatres());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    public void theatreAndEventsLogic(String receivedMessage, long chatId, String userName, long messageId) {
        if (receivedMessage.startsWith("T_")) {
            String venueIdString = receivedMessage.substring(2);
            int venueId = Integer.parseInt(venueIdString);
            sendEventsForTheatre(chatId, venueId, messageId);
        } else if (receivedMessage.startsWith("Event_")) {
            String eventNameIdString = receivedMessage.substring("Event_".length());
            long eventNameId = Long.parseLong(eventNameIdString);
            saveUserFilter(eventNameId, chatId, userName, messageId);
        }
        else {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Упс! Что-то пошло не так. Попробуй попозже...");
            sendMessage(message);
        }
    }

    public void sendEventsForTheatre(Long chatId, int venueId, long messageId) {
        List<EventName> events = eventNameRepository.findByVenueId(venueId);

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        for (EventName event : events) {
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(event.getTitle());
            button.setCallbackData("Event_" + event.getId());
            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(button);
            rowsInline.add(row);
        }

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInline);

        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Выбери мероприятие, показ которого будем отслеживать:");
        message.setReplyMarkup(markupInline);
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    public void saveUserFilter(Long eventNameId, Long chatId, String userName, long messageId) {
        if (!savedFilterRepository.existsByEventNameIdAndChatId(eventNameId, chatId)) {
            Optional<EventName> eventNameOptional = eventNameRepository.findById(eventNameId);

            eventNameOptional.ifPresent(eventName -> {
                SavedFilter savedFilter = new SavedFilter();
                savedFilter.setEventName(eventName);
                savedFilter.setChatId(chatId);
                savedFilter.setTitle(eventName.getTitle());
                savedFilter.setUserName(userName);
                savedFilterRepository.save(savedFilter);

                EditMessageText message = new EditMessageText();
                message.setChatId(chatId);
                message.setText
                        ("Готово! Я сохранил это мероприятие для тебя и сразу пришлю уведомление, как только на это событие начнется повторная продажа билетов!"
                                + " Сохраним еще какое-нибудь преставление или пока хватит? :)");
                message.setReplyMarkup(Buttons.YesNoMarkup());
                message.setMessageId((int) messageId);
                editMessage(message);

            });
        } else {
            EditMessageText message = new EditMessageText();
            message.setChatId(chatId);
            message.setText
                    ("Выбранное мероприятие уже было сохранено для тебя ранее. Всё в порядке, ожидай уведомление." +
                            " Кстати, ты можешь выбрать сколько угодно событий! Продолжаем или достаточно? :)");
            message.setReplyMarkup(Buttons.YesNoMarkup());
            message.setMessageId((int) messageId);
            editMessage(message);
        }
    }

    @Async("taskExecutor")
    public void checkAndSendPresaleNotifications(Event event) {
        List<SavedFilter> savedFilters = savedFilterRepository.findByEventNameId(event.getEventName().getId());
        for (SavedFilter savedFilter : savedFilters) {
            sendPresaleNotification(savedFilter.getChatId(), savedFilter);
        }
    }

    public void sendPresaleNotification(Long chatId, SavedFilter savedFilter) {
        SendMessage message1 = new SendMessage();
        message1.setChatId(chatId);
        message1.setText("Привет! Началась продажа билетов на мероприятие " + savedFilter.getTitle());
        sendMessage(message1);
    }

    public void yesButton(Long chatId, String userName, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText(userName + ", отлично! Тогда давай еще раз уточним по городу:");
        message.setReplyMarkup(Buttons.inlineMarkUpRegions());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    public void noButton(Long chatId, String username, long messageId) {
        String goodDay = "Без проблем! " + username + ", тогда заходи, когда понадоблюсь! Отличного тебе дня! :)";
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText(goodDay);
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    public void tryButton(Long chatId, long messageId) {
        EditMessageText message = new EditMessageText();
        message.setChatId(chatId);
        message.setText("Хорошо! Давай начнем с выбора города:");
        message.setReplyMarkup(Buttons.inlineMarkUpRegions());
        message.setMessageId((int) messageId);
        editMessage(message);
    }

    public void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public void editMessage(EditMessageText message) {
        try {
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}