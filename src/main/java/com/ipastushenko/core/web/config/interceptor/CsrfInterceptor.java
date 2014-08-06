package com.ipastushenko.core.web.config.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Csrf interceptor
 */
public class CsrfInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) throws Exception {
        modelAndView.addObject("_csrf", request.getAttribute("_csrf"));
    }
}
