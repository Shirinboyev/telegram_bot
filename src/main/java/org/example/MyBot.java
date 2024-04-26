package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        try {
            Long user1 = 5980239060L ;
            Long user2 = 1712225965L ;

            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            if(chatId.equals(user1)){

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(user2);
            sendMessage.setText(text);
            execute(sendMessage);

            }else if(chatId.equals(user2)){

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(user1);
                sendMessage.setText(text);
                execute(sendMessage);

            }

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
