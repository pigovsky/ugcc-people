package org.ugcc.people.chatbot.telegram.models;


/**
 * chat={
 *  id=122462923,
 *  first_name=Jurgen,
 *  last_name=Pigowski,
 *  type=private
 * }
 */
public class Chat {
    private long id;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
