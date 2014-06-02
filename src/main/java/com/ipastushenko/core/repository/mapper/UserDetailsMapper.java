package com.ipastushenko.core.repository.mapper;

import com.ipastushenko.core.model.UserDetailsImpl;

/**
 * user details mapper
 */
public interface UserDetailsMapper {
    /**
     * find user details by username
     * @param username userbane
     * @return user or null
     */
    UserDetailsImpl findByUsername(String username);
}
