package com.ipastushenko.core.web.config.security;

import com.ipastushenko.core.utils.SessionAttributeCode;
import com.ipastushenko.core.web.config.security.exception.NotConfirmedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * authentication failure handler
 */
public class AuthenticationFailureHandlerImpl extends ExceptionMappingAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof BadCredentialsException) {
            request.getSession().setAttribute(SessionAttributeCode.BAD_CREDENTIALS.name(), Boolean.TRUE);
        }
        if (exception instanceof NotConfirmedException) {
            request.getSession().setAttribute(
                    SessionAttributeCode.NOT_CONFIRMED_USERNAME.name(),
                    ((NotConfirmedException)exception).getUsername()
            );
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
