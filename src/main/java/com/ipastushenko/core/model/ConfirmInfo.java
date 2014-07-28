package com.ipastushenko.core.model;

import java.io.Serializable;

/**
 * information for confirm email
 */
public class ConfirmInfo implements Serializable {
    private static final long serialVersionUID = -7513815355596726340L;

    private String confirmCode;

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }
}
