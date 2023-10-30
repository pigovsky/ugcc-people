package org.ugcc.people.chatbot.telegram.models;

import java.util.List;

public class UpdatesResponse {
    private List<UpdateResponse> result;

    public List<UpdateResponse> getResult() {
        return result;
    }

    public void setResult(List<UpdateResponse> result) {
        this.result = result;
    }
}
