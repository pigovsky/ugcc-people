package org.ugcc.people.user;

import org.ugcc.people.chatbot.telegram.models.TelegramUser;

public class User {
    private String id;
    private String firstName;
    private String lastName;

    private Long telegramChatId;

    private String language;

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static User fromTelegramUser(TelegramUser telegramUser) {
        return new User(
            telegramUser.getExternalId(),
            telegramUser.getFirstName(),
            telegramUser.getLastName()
        );
    }

    public Long getTelegramChatId() {
        return telegramChatId;
    }

    public void setTelegramChatId(Long telegramChatId) {
        this.telegramChatId = telegramChatId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
