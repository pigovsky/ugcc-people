package org.ugcc.people.chatbot.telegram.models;

import jakarta.annotation.Nullable;

public class GetUpdateRequest {
    private int timeout = 600;

    @Nullable
    private Integer offset = null;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Nullable
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(@Nullable Integer offset) {
        this.offset = offset;
    }
}
