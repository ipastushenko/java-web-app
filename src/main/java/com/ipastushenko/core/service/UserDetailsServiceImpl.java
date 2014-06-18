package com.ipastushenko.core.service;

import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * user details service
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsImpl userDetails = userDetailsRepository.findByUsername(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return userDetails;
    }

    public UserDetailsImpl update(UserDetailsImpl userDetails) {
        if (userDetails == null) {
            return null;
        }
        if (userDetails.getId() == null) {
            return null;
        }
        userDetailsRepository.update(userDetails);

        return userDetails;
    }
}
