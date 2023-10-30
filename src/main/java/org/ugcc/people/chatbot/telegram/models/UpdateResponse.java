package org.ugcc.people.chatbot.telegram.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateResponse {
    private Message message;

    private int updateId;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @JsonProperty("update_id")
    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    @Override
    public String toString() {
        /**
         * Outputs something like
         *
         * UpdateResponse{
         *   message={
         *     message_id=1352,
         *     from={
         *       id=122462923,
         *       is_bot=false,
         *       first_name=Jurgen,
         *       last_name=Pigowski,
         *       language_code=nl
         *     },
         *     chat={
         *       id=122462923,
         *       first_name=Jurgen,
         *       last_name=Pigowski,
         *       type=private
         *     },
         *     date=1703156175,
         *     text=ü
         *   },
         *   updateId=352148739
         * }
         */
        return "UpdateResponse{" +
                "message=" + message +
                ", updateId=" + updateId +
                '}';
    }
}
