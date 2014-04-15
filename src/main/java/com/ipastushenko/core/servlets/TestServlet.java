package com.ipastushenko.core.servlets;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * test servlet
 */
public class TestServlet implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(
            ServletRequest servletRequest,
            ServletResponse servletResponse
    ) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter printWriter = servletResponse.getWriter();
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <title>Test Filter Servlet</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println(servletRequest.getAttribute("name"));
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Test Filters Servlet";
    }

    @Override
    public void destroy() {
    }
}
