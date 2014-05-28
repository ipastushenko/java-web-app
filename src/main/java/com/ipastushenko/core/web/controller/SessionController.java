package com.ipastushenko.core.web.controller;

import com.ipastushenko.core.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * session controller
 */
@Controller
public class SessionController {
    @Autowired
    private TestService testService;

    private static Logger log = Logger.getLogger(SessionController.class.getName());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        Connection connection = null;
        try {
            connection = testService.getDataSource().getConnection();
            log.info("CONNECTION OPEN!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            connection.close();
            log.info("CONNECTION CLOSE!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (SQLException ignored) {
        }
        return new ModelAndView("auth/login");
    }
}
