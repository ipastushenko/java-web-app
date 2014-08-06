package com.ipastushenko.core.web.config.interceptor;

import com.ipastushenko.core.helper.UrlHelper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * url interceptor
 */
public class UrlInterceptor extends HandlerInterceptorAdapter {
    private UrlHelper urlHelper;

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) throws Exception {
        modelAndView.addObject("urlHelper", urlHelper);
    }

    public void setUrlHelper(UrlHelper urlHelper) {
        this.urlHelper = urlHelper;
    }
}
