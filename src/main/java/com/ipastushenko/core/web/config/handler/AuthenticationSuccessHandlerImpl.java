package com.ipastushenko.core.web.config.handler;

import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * auth success handler
 */
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        if (userDetails != null) {
            userDetails.setLastIp(request.getRemoteHost());
            userDetails.setLastLogin(new Timestamp(new Date().getTime()));
            userDetailsService.update(userDetails);
            request.getSession().setAttribute("currentUser", userDetails);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
