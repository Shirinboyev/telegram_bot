package org.example;

public class TelegramState {
    private Long chatId;
    private String state;
    private User user = new User();
    private String selectedProduct;


    public TelegramState(Long chatId, String state) {
        this.chatId = chatId;
        this.state = state;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }

    public TelegramState(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void setSelectedProduct(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TelegramState() {
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
