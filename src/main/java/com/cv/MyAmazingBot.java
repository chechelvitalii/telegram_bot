package com.cv;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyAmazingBot extends TelegramLongPollingBot {

    public static final String TOKEN = "391777415:AAGSrUbXMaCFqVyeR6v5fyFDqIQnVab3-Jc";
    public static final String BOT_NAME = "K1evbot";

    private String sokacavo = "Сокацаво ?";
    private String whyIs = "Тiмур це ты ?";

    public void onUpdateReceived(Update update) {


        if (update.hasMessage() && update.getMessage().hasText()) {

//            SendMessage message;
//
            long chatId = update.getMessage().getChatId();
            String inputText = update.getMessage().getText();
            System.out.println(chatId+"   #   "+inputText);

            if (inputText.equals("/markup")) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chatId)
                        .setText("Here is your keyboard");
                // Create ReplyKeyboardMarkup object
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                keyboardMarkup.setOneTimeKeyboard(true);
                // Create the keyboard (list of keyboard rows)
                List<KeyboardRow> keyboard = new ArrayList<>();
                // Create a keyboard row
                KeyboardRow row = new KeyboardRow();
                // Set each button, you can also use KeyboardButton objects if you need something else than text
                KeyboardButton keyboardButton = new KeyboardButton("Row 1 Button 1");
                keyboardButton.setRequestContact(true);
//                keyboardButton.setRequestLocation(true);
                KeyboardButton keyboardButtonLocation = new KeyboardButton("Location");
                keyboardButtonLocation.setRequestLocation(true);
                row.add(keyboardButton);
                row.add(keyboardButtonLocation);
                row.add("Row 1 Button 3");
                // Add the first row to the keyboard
                keyboard.add(row);
                // Create another keyboard row
                row = new KeyboardRow();
                // Set each button for the second line
                row.add("Row 2 Button 1");
                row.add("Row 2 Button 2");
                row.add("Row 2 Button 3");
                // Add the second row to the keyboard
                keyboard.add(row);
                // Set the keyboard to the markup
                keyboardMarkup.setKeyboard(keyboard);
                // Add it to the message
                message.setReplyMarkup(keyboardMarkup);
                try {
                    sendMessage(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }


//

//            switch (inputText) {
//                case "Привет":
//                    message = new SendMessage()
//                            .setChatId(chatId)
//                            .setText(whyIs);
//                    break;
//                case "Да":
//                    message = new SendMessage()
//                            .setChatId(chatId)
//                            .setText(sokacavo);
//                    break;
//                default:
//                    message = new SendMessage()
//                            .setChatId(chatId)
//                            .setText("Пока я не могу тебе ничем помочь ;)");
//            }
//
//
//            try {
//                sendMessage(message); // Sending our message object to user
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
        }
    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}
