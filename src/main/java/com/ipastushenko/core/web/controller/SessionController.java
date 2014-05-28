package com.ipastushenko.core.web.controller;

import com.ipastushenko.core.web.model.User;
import com.ipastushenko.core.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

/**
 * session controller
 */
@Controller
public class SessionController {
    @Autowired
    private UserService testService;

    private static Logger log = Logger.getLogger(SessionController.class.getName());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("auth/login");
    }
}
