package com.ipastushenko.core.repository.mapper;

import com.ipastushenko.core.model.User;

/**
 * user mapper
 */
public interface UserMapper {
    /**
     * find user by id
     * @param id id
     * @return User or null
     */
    User find(Long id);
}
