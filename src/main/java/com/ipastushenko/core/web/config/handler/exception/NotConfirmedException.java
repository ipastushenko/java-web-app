package com.ipastushenko.core.web.config.handler.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * non confirmed exception
 */
public class NotConfirmedException extends AuthenticationException {
    private static final long serialVersionUID = -3841385373761119562L;

    public NotConfirmedException(String msg) {
        super(msg);
    }
}
