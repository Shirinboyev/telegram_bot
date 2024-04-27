package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    List<TelegramState> users = new ArrayList<>();
    @Override
    public void onUpdateReceived(Update update) {
        try {
            Long chatId = update.getMessage().getChatId();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText("Button");

            List<KeyboardRow> rows = new ArrayList<>();
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(rows);

            KeyboardRow row = new KeyboardRow();
            KeyboardRow row1 = new KeyboardRow();

            KeyboardButton button = new KeyboardButton();
            button.setText("Button 1");

            KeyboardButton button1 = new KeyboardButton();
            button1.setText("Button 2");

            KeyboardButton button2 = new KeyboardButton();
            button2.setText("Button 3");

            row.add(button);
            row.add(button1);
            row1.add(button2);
            rows.add(row);
            rows.add(row1);

            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            execute(sendMessage);

        } catch (Exception e) {
        }
    }

    @Override
    public String getBotUsername() {
        return "shirinboyevtestbot";
    }
    @Override
    public String getBotToken() {
        return "7065868832:AAG8VwBarwl-R-c5QVnxCjHfBMqV3Htk7h8";
    }
}
