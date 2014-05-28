package com.ipastushenko.core.service;

import com.ipastushenko.core.model.User;
import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.repository.UserDetailsRepository;
import com.ipastushenko.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * test service
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User find(Long id) {
        return userRepository.find(id);
    }
}
