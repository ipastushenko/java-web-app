package com.ipastushenko.core.web.controller;

import com.ipastushenko.core.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * session controller
 */
@Controller
public class SessionController {
    private static Logger log = Logger.getLogger(SessionController.class.getName());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        if (SessionUtils.getCurrentUserDetails(request.getSession()) != null) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView model = new ModelAndView("auth/login");
        if (SessionUtils.checkBadCredentials(request.getSession())) {
            model.addObject("authErrorMessage", "Invalid username or password");
        }
        return model;
    }
}
