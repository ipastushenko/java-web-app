package com.ipastushenko.core.web.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Role
 */
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 432447842614898934L;

    private String role;

    //TODO: need change(users many to many roles)!
    @Override
    public String getAuthority() {
        return "ROLE_USER";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
