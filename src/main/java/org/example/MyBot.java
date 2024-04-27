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
            String text = update.getMessage().getText();
            TelegramState currentUser = findByChatId(chatId);

            if(text.equals("/start")){
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("Assalomu alekum botga xush kelibsiz 🙋🏼‍♂️ \nIltimos ismingizni kiriting !");
                execute(sendMessage);
                currentUser.setState(UserState.ENTER_FIRSTNAME);
            }else {
                if (currentUser.getState().equals(UserState.ENTER_FIRSTNAME)) {
                    currentUser.getUser().setFirstName(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Mahsulotni tanlang !");

                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    List<KeyboardRow> rows = new ArrayList<>();

                    KeyboardRow row1 = new KeyboardRow();
                    KeyboardRow row2 = new KeyboardRow();
                    KeyboardRow row3 = new KeyboardRow();

                    KeyboardButton button1 = new KeyboardButton("Pizza");
                    KeyboardButton button2 = new KeyboardButton("Burger");
                    KeyboardButton button3 = new KeyboardButton("Lavash");
                    KeyboardButton button4 = new KeyboardButton("Somsa");
                    KeyboardButton button5 = new KeyboardButton("Lag'mon");
                    KeyboardButton button6 = new KeyboardButton("Osh");
                    KeyboardButton button7 = new KeyboardButton("Hot-dog");
                    KeyboardButton button8 = new KeyboardButton("Sho'rva");
                    KeyboardButton button9 = new KeyboardButton("Chuchvara");


                    row1.add(button1);
                    row1.add(button2);
                    row1.add(button3);
                    row2.add(button4);
                    row2.add(button5);
                    row2.add(button6);
                    row3.add(button7);
                    row3.add(button8);
                    row3.add(button9);

                    rows.add(row1);
                    rows.add(row2);
                    rows.add(row3);
                    replyKeyboardMarkup.setKeyboard(rows);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);


                    execute(sendMessage);
                    currentUser.setState(UserState.SELECT_PRODUCT);
                }
                else if (currentUser.getState().equals(UserState.SELECT_PRODUCT)) {
                    currentUser.setSelectedProduct(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    if (text.equals("Pizza")) {
                        sendMessage.setText("120 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Burger")) {
                        sendMessage.setText("35 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Lavash")) {
                        sendMessage.setText("30 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Somsa")) {
                        sendMessage.setText("12 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Lag'mon")) {
                        sendMessage.setText("40 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Osh")) {
                        sendMessage.setText("50 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Hot-dog")) {
                        sendMessage.setText("20 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Sho'rva")) {
                        sendMessage.setText("35 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    else if (text.equals("Chuchvara")) {
                        sendMessage.setText("35 000\nOldin to'lovni qiling\n4072 4200 7239 5902\nIbrohim Shirinboyev\nTo'lov qilganingizdan keyin yozing ? ");
                    }
                    execute(sendMessage);
                    currentUser.setState(UserState.IS_PAID);
                }else if(currentUser.getState().equals(UserState.IS_PAID)){
                    currentUser.setSelectedProduct(text);
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Hali To'lov qilinmadi !🤬!");
                    execute(sendMessage);
                }
                /*else {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Iltimos faqat buttonlardan foydalaning !");
                    execute(sendMessage);
                }*/


            };



        } catch (Exception e) {
        }
    }
    private TelegramState findByChatId(Long chatId) {
        for (TelegramState user : users) {
            if(user.getChatId().equals(chatId)){
                return user;
            }
        }

        TelegramState telegramState = new TelegramState();
        telegramState.setChatId(chatId);
        telegramState.setState(UserState.START);
        users.add(telegramState);
        return telegramState;
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
