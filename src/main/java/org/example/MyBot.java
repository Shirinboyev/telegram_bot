package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    String name;
    String lastname;
    String STATE = "START";

    @Override
    public void onUpdateReceived(Update update) {
        try {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if(text.equals("/start")){
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Assalomu alekum! Botga xush kelibsiz\nIltimos ismingizni kiriting 😌");
                sendMessage.setChatId(chatId);
                execute(sendMessage);
                STATE = "ENTER_FIRSTNAME";
            } else {
                if (STATE.equals("ENTER_FIRSTNAME")) {
                    name = text;
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Iltimos familiyangizni kiriting 😌");
                    sendMessage.setChatId(chatId);
                    execute(sendMessage);
                    STATE = "ENTER_LASTNAME";
                } else if (STATE.equals("ENTER_LASTNAME")) {
                    lastname = text;
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Siz ro'yxatdan o'tdingiz 🥳\n" +
                                        "Sizga qanday yordam bera olamiz");
                    sendMessage.setChatId(chatId);
                    execute(sendMessage);
                    STATE = "REGISTERED";
                } else if (STATE.equals("REGISTERED")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Iltimos Admin Javobini Kuting 😌");
                    Thread.sleep(1000);
                    System.out.println("Lekin senga hech kim javob bermaydi 🤣🤣🤣 ");
                    sendMessage.setChatId(chatId);
                    execute(sendMessage);
                }
            }
        } catch (TelegramApiException e) {
        } catch (InterruptedException e) {
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
