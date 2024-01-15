package org.ugcc.people.session;

import org.ugcc.people.user.User;

public class LoginResponse {
    private String sessionKey;
    private User user;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginResponse(String sessionKey, User user) {
        this.sessionKey = sessionKey;
        this.user = user;
    }
}
