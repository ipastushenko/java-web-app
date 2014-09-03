package com.ipastushenko.core.web.controller;

import com.ipastushenko.core.service.EmailService;
import com.ipastushenko.core.service.UserDetailsServiceImpl;
import com.ipastushenko.core.service.exception.ServiceException;
import com.ipastushenko.core.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * registration controller
 */
@Controller
public class RegistrationController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/send-confirm-info", method = RequestMethod.GET)
    public ModelAndView confirmInfo(HttpServletRequest request) {
        String username = SessionUtils.getNotConfirmedUsername(request.getSession());
        if (username == null) {
            return new ModelAndView("redirect:/");
        }
        ModelAndView model = new ModelAndView("auth/send-confirm-info");
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(value = "/send-confirm-info", method = RequestMethod.POST)
    public ModelAndView sendConfirmInfo(String username) {
        try {
            emailService.sendMail("java-web-app", username, "Confirm information", "TEST");
        } catch (ServiceException e) {
            //TODO: add notifications
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("auth/confirm-info");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(HttpServletRequest request) {
        if (SessionUtils.getCurrentUserDetails(request.getSession()) != null) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("auth/registration");
    }
}
