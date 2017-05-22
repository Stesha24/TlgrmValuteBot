import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Body of Bot.
 */
class Main extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Main());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "ValuteBot";
    }

    @Override
    public String getBotToken() {
        return "336811108:AAE28HwkYxTuq7FBxD5z18Qj8wzsWuDC1lE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String id;

        Date date = new Date();
        ParserIntoMassive parserIntoMassive = new ParserIntoMassive();
        String currValue;
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "USD/RUB":
                    id = "R01235";
                    try {
                        parserIntoMassive.parserIntoMass(id, date.date(), date.prevDate());
                        currValue = GetValute.currentValue(parserIntoMassive.valueMass);
                        System.out.println(parserIntoMassive.dateMass[0]);
                        LineChartEx diagramm = new LineChartEx(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        diagramm.Diagram(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        sendPh(message, "Текущий курс доллара к рублю: " + currValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "EUR/RUB":
                    id = "R01239";
                    try {
                        parserIntoMassive.parserIntoMass(id, date.date(), date.prevDate());
                        currValue = GetValute.currentValue(parserIntoMassive.valueMass);
                        LineChartEx diagramm = new LineChartEx(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        diagramm.Diagram(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        sendPh(message, "Текущий курс евро к рублю: "+currValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    break;
                case "KZT/RUB":
                    id = "R01335";
                    try {
                        parserIntoMassive.parserIntoMass(id, date.date(), date.prevDate());
                        currValue = GetValute.currentValue(parserIntoMassive.valueMass);
                        LineChartEx diagramm = new LineChartEx(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        diagramm.Diagram(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        sendPh(message, "Текущий курс 100 тенге к рублю: " + currValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    break;
                case "GBP/RUB":
                    id = "R01035";
                    try {
                        parserIntoMassive.parserIntoMass(id, date.date(), date.prevDate());
                        currValue = GetValute.currentValue(parserIntoMassive.valueMass);
                        LineChartEx diagramm = new LineChartEx(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        diagramm.Diagram(parserIntoMassive.valueMass, parserIntoMassive.dateMass);
                        sendPh(message, "Текущий курс фунта к рублю: " + currValue);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    try {
                        sendMsg(message, "I don't know this command!");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    private void sendMsg(Message message, String text) throws FileNotFoundException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboad(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("USD/RUB");
        keyboardFirstRow.add("EUR/RUB");

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add("KZT/RUB");
        keyboardSecondRow.add("GBP/RUB");

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);



        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private void sendPh(Message message, String text) throws FileNotFoundException {
        SendPhoto sendPhoto = new SendPhoto();

        InputStream imageFile = new FileInputStream("E:\\TlgrmValuteBot\\image\\LineChart.png");
        sendPhoto.setNewPhoto("graphic",imageFile);
        sendPhoto.setChatId(message.getChatId().toString());
        sendPhoto.setReplyToMessageId(message.getMessageId());
        sendPhoto.setCaption(text);
        try {

            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            sendPhoto(sendPhoto);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
