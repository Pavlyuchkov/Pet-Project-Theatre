package theatre.telegram;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface BotCommands {

    List<BotCommand> LIST_OF_COMMANDS = List.of(
            new BotCommand("/start", "Запустить, либо перезапустить бот"),
            new BotCommand("/choose", "Запустить подбор")
    );

    String HELP_TEXT = """
            Дорогой друг!\s
            Меня зовут Театрик, и я могу помочь тебе получить информацию о театрах Беларуси и показываемых в них представлениях, а самое главное, отправить тебе уведомление на выбранное мероприятие, как только на него начнется продажа билетов.\s
            Тебе необходимо лишь выбрать нужный город и театр, чтобы получить афишу по нему. Удачи!""";
}