package com.ipastushenko.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * session controller
 */
@Controller
public class SessionController {
    private static Logger log = Logger.getLogger(SessionController.class.getName());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("currentUser") != null) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("auth/login");
    }
}
