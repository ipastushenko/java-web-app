package com.ipastushenko.core.web.config.security;

import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.web.config.security.exception.NotConfirmedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

/**
 * custom dao authentication provider
 */
public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {
    public CustomDaoAuthenticationProvider() {
        setPostAuthenticationChecks(new PostAuthenticationChecks());
    }

    private class PostAuthenticationChecks implements UserDetailsChecker {
        public void check(UserDetails user) {
            UserDetailsImpl userDetails = (UserDetailsImpl)user;
            if (userDetails == null) {
                throw new BadCredentialsException(messages.getMessage(
                        "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
            }

            if (!userDetails.getIsConfirmed()) {
                throw new NotConfirmedException("Email is not confirmed", userDetails.getUsername());
            }

            if (!user.isCredentialsNonExpired()) {
                logger.debug("User account credentials have expired");

                throw new CredentialsExpiredException(messages.getMessage(
                        "AbstractUserDetailsAuthenticationProvider.credentialsExpired",
                        "User credentials have expired"));
            }
        }
    }
}
