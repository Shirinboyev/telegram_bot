package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    List<TelegramState> users = new ArrayList<>();
    @Override
    public void onUpdateReceived(Update update) {
        try {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            TelegramState currentUser = null;
            for (TelegramState user : users) {
                if (user.getChatId().equals(chatId)) {
                    currentUser = user;
                }
            }
            if(currentUser == null) {
                currentUser = new TelegramState();
                currentUser.setChatId(chatId);
                users.add(currentUser);
            }


            if(text.equals("/start")){
                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("Assalomu alekum! Botga xush kelibsiz\nIltimos ismingizni kiriting 😌");
                sendMessage.setChatId(chatId);
                execute(sendMessage);
                currentUser.setSTATE(UserState.ENTER_FIRSTNAME);
            } else {
                if (currentUser.getSTATE().equals(UserState.ENTER_FIRSTNAME)) {
                    currentUser.setName(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Iltimos familiyangizni kiriting 😌");
                    sendMessage.setChatId(chatId);
                    execute(sendMessage);
                    currentUser.setSTATE(UserState.ENTER_LASTNAME);
                } else if (currentUser.getSTATE().equals(UserState.ENTER_LASTNAME)) {
                    currentUser.setName(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Siz ro'yxatdan o'tdingiz 🥳\n" +
                                        "Sizga qanday yordam bera olamiz");
                    sendMessage.setChatId(chatId);
                    execute(sendMessage);
                    currentUser.setSTATE(UserState.REGISTERED);
                } else if (currentUser.getSTATE().equals(UserState.REGISTERED)) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Iltimos Admin Javobini Kuting 😌");
                    System.out.println("Lekin senga hech kim javob bermaydi 🤣🤣🤣 ");
                    sendMessage.setChatId(chatId);
                    execute(sendMessage);
                }
            }
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
