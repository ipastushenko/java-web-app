package com.ipastushenko.core.web.config.handler.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * non confirmed exception
 */
public class NotConfirmedException extends UsernameNotFoundException {
    private static final long serialVersionUID = -3841385373761119562L;

    public NotConfirmedException(String msg) {
        super(msg);
    }
}
