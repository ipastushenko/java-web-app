package com.ipastushenko.core.web.config.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * non confirmed exception
 */
public class NotConfirmedException extends AuthenticationException {
    private static final long serialVersionUID = -3841385373761119562L;

    private final String username;

    public NotConfirmedException(String msg, String username) {
        super(msg);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
