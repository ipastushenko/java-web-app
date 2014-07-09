package com.ipastushenko.core.web.config.security;

import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.service.UserDetailsServiceImpl;
import com.ipastushenko.core.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * auth success handler
 */
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {
    private static final Logger log = Logger.getLogger(AuthenticationSuccessHandlerImpl.class.getName());

    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        if (userDetails != null) {
            userDetails.setLastIp(request.getRemoteHost());
            userDetails.setLastLogin(new Timestamp(System.currentTimeMillis()));
            try {
                userDetailsService.update(userDetails);
            } catch (ServiceException e) {
                log.error("IP and time of last login can't update");
            }
            request.getSession().setAttribute("currentUser", userDetails);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
