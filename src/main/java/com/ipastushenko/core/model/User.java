package com.ipastushenko.core.model;

import java.io.Serializable;

/**
 * user model
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4806013184165411572L;

    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
