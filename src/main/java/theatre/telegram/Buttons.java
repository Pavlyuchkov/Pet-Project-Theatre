package theatre.telegram;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.List;

@Service
public class Buttons {

    // Единичные Кнопки
    private static final InlineKeyboardButton START_BUTTON = new InlineKeyboardButton("Рестарт");
    private static final InlineKeyboardButton HELP_BUTTON = new InlineKeyboardButton("Помощь");
    private static final InlineKeyboardButton CHOOSE_BUTTON = new InlineKeyboardButton("Подбор");
    private static final InlineKeyboardButton YES = new InlineKeyboardButton("Да, выберем еще!");
    private static final InlineKeyboardButton NO = new InlineKeyboardButton("Нет, спасибо.");
    private static final InlineKeyboardButton TRY = new InlineKeyboardButton("Понятно. Давай попробуем!");

    // Кнопки Городов
    private static final InlineKeyboardButton MINSK = new InlineKeyboardButton("Минск");
    private static final InlineKeyboardButton BREST = new InlineKeyboardButton("Брест");
    private static final InlineKeyboardButton VITEBSK = new InlineKeyboardButton("Витебск");
    private static final InlineKeyboardButton GOMEL = new InlineKeyboardButton("Гомель");
    private static final InlineKeyboardButton GRODNO = new InlineKeyboardButton("Гродно");
    private static final InlineKeyboardButton MOGILEV = new InlineKeyboardButton("Могилев");
    private static final InlineKeyboardButton OTHER = new InlineKeyboardButton("Другой город");

    // Кнопки Театров
    // Минск
    private static final InlineKeyboardButton MINSK_1 = new InlineKeyboardButton("1. Белгосцирк");
    private static final InlineKeyboardButton MINSK_2 = new InlineKeyboardButton("2. Государственный музыкальный театр");
    private static final InlineKeyboardButton MINSK_3 = new InlineKeyboardButton("3. Большой театр Беларуси");
    private static final InlineKeyboardButton MINSK_17 = new InlineKeyboardButton("4. Драматический театр белорусской армии");
    private static final InlineKeyboardButton MINSK_18 = new InlineKeyboardButton("5. Концертный зал 'Минск'");
    private static final InlineKeyboardButton MINSK_20 = new InlineKeyboardButton("7. Молодежный театр эстрады");
    private static final InlineKeyboardButton MINSK_22 = new InlineKeyboardButton("8. Молодежный театр");
    private static final InlineKeyboardButton MINSK_27 = new InlineKeyboardButton("9. Дворец культуры профсоюзов");
    private static final InlineKeyboardButton MINSK_29 = new InlineKeyboardButton("10. Театр-студия Киноактера");
    private static final InlineKeyboardButton MINSK_30 = new InlineKeyboardButton("11. Театр им.Максима Горького");
    private static final InlineKeyboardButton MINSK_31 = new InlineKeyboardButton("12. Театр им.Янки Купалы");
    private static final InlineKeyboardButton MINSK_32 = new InlineKeyboardButton("13. Театр юного зрителя");
    private static final InlineKeyboardButton MINSK_33 = new InlineKeyboardButton("14. Центральный дом офицеров");
    private static final InlineKeyboardButton MINSK_39 = new InlineKeyboardButton("15. Дворец Республики");

    // Брест
    private static final InlineKeyboardButton BREST_4 = new InlineKeyboardButton("1. Брестский академический театр драмы");
    private static final InlineKeyboardButton BREST_24 = new InlineKeyboardButton("2. Областной общественно-культурный центр");

    // Витебск
    private static final InlineKeyboardButton VITEBSK_12 = new InlineKeyboardButton("1. ДК Железнодорожников");
    private static final InlineKeyboardButton VITEBSK_23 = new InlineKeyboardButton("2. НАДТ им. Якуба Коласа");
    private static final InlineKeyboardButton VITEBSK_40 = new InlineKeyboardButton("3. Концертный зал");

    // Гомель
    private static final InlineKeyboardButton GOMEL_5 = new InlineKeyboardButton("1. Гомельский государственный театр кукол");
    private static final InlineKeyboardButton GOMEL_6 = new InlineKeyboardButton("2. Гомельский областной драматический театр");
    private static final InlineKeyboardButton GOMEL_7 = new InlineKeyboardButton("3. Гомельский общественно-культурный центр");
    private static final InlineKeyboardButton GOMEL_21 = new InlineKeyboardButton("4. Молодежный театр");
    private static final InlineKeyboardButton GOMEL_34 = new InlineKeyboardButton("5. Гомельская областная филармония");


    // Гродно
    private static final InlineKeyboardButton GRODNO_8 = new InlineKeyboardButton("1. Гродненская областная филармония");

    // Могилев
    private static final InlineKeyboardButton MOGILEV_25 = new InlineKeyboardButton("1. Областной центр творчества");
    private static final InlineKeyboardButton MOGILEV_36 = new InlineKeyboardButton("2. ДК культуры области");

    // Другие города
    private static final InlineKeyboardButton OTHER_9 = new InlineKeyboardButton("1. Мозырь. ДК Мозырский НПЗ");
    private static final InlineKeyboardButton OTHER_10 = new InlineKeyboardButton("2. Барановичи. Дом Культуры");
    private static final InlineKeyboardButton OTHER_11 = new InlineKeyboardButton("3. Солигорск. Дом Культуры ");
    private static final InlineKeyboardButton OTHER_13 = new InlineKeyboardButton("4. Новополоцк, ДК Нафтан");
    private static final InlineKeyboardButton OTHER_14 = new InlineKeyboardButton("5. Орша. ДК Железнодорожников");
    private static final InlineKeyboardButton OTHER_15 = new InlineKeyboardButton("6. Борисов. ДК им.Горького");
    private static final InlineKeyboardButton OTHER_16 = new InlineKeyboardButton("7. Жодино. ДК БелАз");
    private static final InlineKeyboardButton OTHER_26 = new InlineKeyboardButton("8. Пинск. Дом Культуры");
    private static final InlineKeyboardButton OTHER_28 = new InlineKeyboardButton("9. Слуцк. Дом Культуры");
    private static final InlineKeyboardButton OTHER_19 = new InlineKeyboardButton("10. Молодечно. Минский областной драматический театр");
    private static final InlineKeyboardButton OTHER_38 = new InlineKeyboardButton("11. Молодечно. Дом Культуры");
    private static final InlineKeyboardButton OTHER_35 = new InlineKeyboardButton("12. Несвиж. Двор\\Зал замка Радзивиллов");
    private static final InlineKeyboardButton OTHER_37 = new InlineKeyboardButton("13. Полоцк. Центр культуры");


    public static InlineKeyboardMarkup inlineMarkupStartHelp() {
        START_BUTTON.setCallbackData("/start");
        HELP_BUTTON.setCallbackData("/help");
        CHOOSE_BUTTON.setCallbackData("/choose");

        List<InlineKeyboardButton> rowInline = List.of(START_BUTTON, HELP_BUTTON, CHOOSE_BUTTON);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup YesNoMarkup() {
        YES.setCallbackData("YesButton");
        NO.setCallbackData("NoButton");

        List<InlineKeyboardButton> rowInline = List.of(YES, NO);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup tryMarkup() {
        TRY.setCallbackData("TryButton");

        List<InlineKeyboardButton> rowInline = List.of(TRY);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup inlineMarkUpRegions() {
        MINSK.setCallbackData("Minsk");
        BREST.setCallbackData("Brest");
        VITEBSK.setCallbackData("Vitebsk");
        GOMEL.setCallbackData("Gomel");
        GRODNO.setCallbackData("Grodno");
        MOGILEV.setCallbackData("Mogilev");
        OTHER.setCallbackData("Other");

        List<InlineKeyboardButton> row1 = List.of(MINSK, BREST, VITEBSK, GOMEL);
        List<InlineKeyboardButton> row2 = List.of(GRODNO, MOGILEV, OTHER);

        List<List<InlineKeyboardButton>> rowsInLine = List.of(row1, row2);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup MinskTheatres() {
        MINSK_1.setCallbackData("T_1");
        MINSK_2.setCallbackData("T_2");
        MINSK_3.setCallbackData("T_3");
        MINSK_17.setCallbackData("T_17");
        MINSK_18.setCallbackData("T_18");
        MINSK_20.setCallbackData("T_20");
        MINSK_22.setCallbackData("T_22");
        MINSK_27.setCallbackData("T_27");
        MINSK_29.setCallbackData("T_29");
        MINSK_30.setCallbackData("T_30");
        MINSK_31.setCallbackData("T_31");
        MINSK_32.setCallbackData("T_32");
        MINSK_33.setCallbackData("T_33");
        MINSK_39.setCallbackData("T_39");

        List<InlineKeyboardButton> row1 = List.of(MINSK_1);
        List<InlineKeyboardButton> row2 = List.of(MINSK_2);
        List<InlineKeyboardButton> row3 = List.of(MINSK_3);
        List<InlineKeyboardButton> row4 = List.of(MINSK_17);
        List<InlineKeyboardButton> row5 = List.of(MINSK_18);
        List<InlineKeyboardButton> row6 = List.of(MINSK_20);
        List<InlineKeyboardButton> row7 = List.of(MINSK_22);
        List<InlineKeyboardButton> row8 = List.of(MINSK_27);
        List<InlineKeyboardButton> row9 = List.of(MINSK_29);
        List<InlineKeyboardButton> row10 = List.of(MINSK_30);
        List<InlineKeyboardButton> row11 = List.of(MINSK_31);
        List<InlineKeyboardButton> row12 = List.of(MINSK_32);
        List<InlineKeyboardButton> row13 = List.of(MINSK_33);
        List<InlineKeyboardButton> row14 = List.of(MINSK_39);

        List<List<InlineKeyboardButton>> rowsInLine = List.of(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13, row14);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup BrestTheatres() {
        BREST_4.setCallbackData("T_4");
        BREST_24.setCallbackData("T_24");

        List<InlineKeyboardButton> row1 = List.of(BREST_4);
        List<InlineKeyboardButton> row2 = List.of(BREST_24);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(row1, row2);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup VitebskTheatres() {
        VITEBSK_12.setCallbackData("T_12");
        VITEBSK_23.setCallbackData("T_23");
        VITEBSK_40.setCallbackData("T_40");

        List<InlineKeyboardButton> row1 = List.of(VITEBSK_12);
        List<InlineKeyboardButton> row2 = List.of(VITEBSK_23);
        List<InlineKeyboardButton> row3 = List.of(VITEBSK_40);

        List<List<InlineKeyboardButton>> rowsInLine = List.of(row1, row2, row3);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup GomelTheatres() {
        GOMEL_5.setCallbackData("T_5");
        GOMEL_6.setCallbackData("T_6");
        GOMEL_7.setCallbackData("T_7");
        GOMEL_21.setCallbackData("T_21");
        GOMEL_34.setCallbackData("T_34");

        List<InlineKeyboardButton> row1 = List.of(GOMEL_5);
        List<InlineKeyboardButton> row2 = List.of(GOMEL_6);
        List<InlineKeyboardButton> row3 = List.of(GOMEL_7);
        List<InlineKeyboardButton> row4 = List.of(GOMEL_21);
        List<InlineKeyboardButton> row5 = List.of(GOMEL_34);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(row1, row2, row3, row4, row5);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup GrodnoTheatres() {
        GRODNO_8.setCallbackData("T_8");

        List<InlineKeyboardButton> rowInline = List.of(GRODNO_8);
        List<List<InlineKeyboardButton>> rowsInLine = List.of(rowInline);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup MogilevTheatres() {
        MOGILEV_25.setCallbackData("T_25");
        MOGILEV_36.setCallbackData("T_36");

        List<InlineKeyboardButton> row1 = List.of(MOGILEV_25);
        List<InlineKeyboardButton> row2 = List.of(MOGILEV_36);

        List<List<InlineKeyboardButton>> rowsInLine = List.of(row1, row2);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }

    public static InlineKeyboardMarkup OtherTheatres() {
        OTHER_9.setCallbackData("T_9");
        OTHER_10.setCallbackData("T_10");
        OTHER_11.setCallbackData("T_11");
        OTHER_13.setCallbackData("T_13");
        OTHER_14.setCallbackData("T_14");
        OTHER_15.setCallbackData("T_15");
        OTHER_16.setCallbackData("T_16");
        OTHER_26.setCallbackData("T_26");
        OTHER_28.setCallbackData("T_28");
        OTHER_19.setCallbackData("T_19");
        OTHER_38.setCallbackData("T_38");
        OTHER_35.setCallbackData("T_35");
        OTHER_37.setCallbackData("T_37");

        List<InlineKeyboardButton> row1 = List.of(OTHER_9);
        List<InlineKeyboardButton> row2 = List.of(OTHER_10);
        List<InlineKeyboardButton> row3 = List.of(OTHER_11);
        List<InlineKeyboardButton> row4 = List.of(OTHER_13);
        List<InlineKeyboardButton> row5 = List.of(OTHER_14);
        List<InlineKeyboardButton> row6 = List.of(OTHER_15);
        List<InlineKeyboardButton> row7 = List.of(OTHER_16);
        List<InlineKeyboardButton> row8 = List.of(OTHER_26);
        List<InlineKeyboardButton> row9 = List.of(OTHER_28);
        List<InlineKeyboardButton> row10 = List.of(OTHER_19);
        List<InlineKeyboardButton> row11 = List.of(OTHER_38);
        List<InlineKeyboardButton> row12 = List.of(OTHER_35);
        List<InlineKeyboardButton> row13 = List.of(OTHER_37);

        List<List<InlineKeyboardButton>> rowsInLine = List.of(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}