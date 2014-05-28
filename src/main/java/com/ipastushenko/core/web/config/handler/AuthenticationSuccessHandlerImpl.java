package com.ipastushenko.core.web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * auth success handler
 */
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        if (userDetails != null) {
            request.getSession().setAttribute("currentUser", userDetails.getUsername());
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
