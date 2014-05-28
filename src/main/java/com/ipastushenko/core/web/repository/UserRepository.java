package com.ipastushenko.core.web.repository;

import com.ipastushenko.core.web.model.User;
import com.ipastushenko.core.web.repository.mapper.UserMapper;
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

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
