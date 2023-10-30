package org.ugcc.people.chatbot.telegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * message={
 *     message_id=1352,
 *     from=User,
 *     chat={
 *       id=122462923,
 *       first_name=Jurgen,
 *       last_name=Pigowski,
 *       type=private
 *     },
 *     date=1703156175,
 *     text=ü
 *   }
 */
public class Message {
    private int messageId;
    private User from;
    private Chat chat;
    private long date;
    private String text;

    @JsonProperty("message_id")
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
