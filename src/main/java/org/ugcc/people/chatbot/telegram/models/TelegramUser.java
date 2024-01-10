package org.ugcc.people.chatbot.telegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TelegramUser {
    /**
     * {
     *   id=122462923,
     *   is_bot=false,
     *   first_name=Jurgen,
     *   last_name=Pigowski,
     *   language_code=nl
     * }
     */
    private long id;
    private boolean isBot;
    private String firstName;
    private String lastName;
    private String languageCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("is_bot")
    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("language_code")
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getFullName() {
        return "%s %s".formatted(firstName, lastName);
    }

    public String getExternalId() {
        return "telegram" + this.getId();
    }
}
