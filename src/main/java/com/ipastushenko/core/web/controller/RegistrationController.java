package com.ipastushenko.core.web.controller;

import com.ipastushenko.core.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * registration controller
 */
@Controller
public class RegistrationController {
    @RequestMapping(value = "/send-confirm-info", method = RequestMethod.GET)
    public ModelAndView sendConfirmInfo(HttpServletRequest request) {
        String username = SessionUtils.getNotConfirmedUsername(request.getSession());
        if (username == null) {
            return new ModelAndView("redirect:/");
        }
        ModelAndView model = new ModelAndView("auth/send-confirm-info");
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(HttpServletRequest request, HttpServletResponse response) {
        if (SessionUtils.getCurrentUserDetails(request.getSession()) != null) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("auth/registration");
    }
}
