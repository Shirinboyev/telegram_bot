package org.example;

public class TelegramState {
    private Long chatId;
    private String name;
    private String lastname;
    private String STATE = "START";

    public TelegramState(String lastname, String name, String STATE) {
        this.lastname = lastname;
        this.name = name;
        this.STATE = STATE;
    }

    public TelegramState() {
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
