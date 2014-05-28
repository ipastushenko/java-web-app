package com.ipastushenko.core.repository;

import com.ipastushenko.core.model.User;
import com.ipastushenko.core.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * user repository
 */
@Repository
public class UserRepository {
    @Autowired
    private UserMapper userMapper;

    public User find(Long id) {
        return userMapper.find(id);
    }
}
