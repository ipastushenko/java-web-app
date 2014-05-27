package com.ipastushenko.core.config.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * access denied handler
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private String errorPage;

    public AccessDeniedHandlerImpl() {
    }

    @Override
    public void handle(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AccessDeniedException e
    ) throws IOException, ServletException {
        httpServletResponse.sendRedirect(errorPage);
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }
}
