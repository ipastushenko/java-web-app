package com.ipastushenko.core.repository;

import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.repository.mapper.UserDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * user details repository
 */
@Repository
public class UserDetailsRepository {
    @Autowired
    private UserDetailsMapper userDetailsMapper;

    public UserDetailsImpl findByUsername(String username) {
        return userDetailsMapper.findByUsername(username);
    }

    public void update(UserDetailsImpl userDetails) {
        userDetailsMapper.update(userDetails);
    }
}
