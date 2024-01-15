package org.ugcc.people.session;

public class LoginError extends RuntimeException {
    public LoginError(String message) {
        super(message);
    }
}
