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


            System.out.println("Start");
            Long myChatid = 1712225965L;
            SendMessage sendMessage = new SendMessage();
            execute(sendMessage);




        } catch (TelegramApiException e) {
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
