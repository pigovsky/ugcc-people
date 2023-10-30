package org.ugcc.people.chatbot.telegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageRequest {
    private Long chatId;

    private String text;

    public MessageRequest(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }

    @JsonProperty("chat_id")
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
