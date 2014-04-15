package com.ipastushenko.core.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * test filters
 */
public class TestFilter implements Filter {
    private String name;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getInitParameter("name");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("name", name);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
