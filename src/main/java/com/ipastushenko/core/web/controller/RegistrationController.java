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
    public ModelAndView sendConfirmInfo(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        ModelAndView model = new ModelAndView("auth/send-confirm-info");
        String username = SessionUtils.findNotConfirmedUsername(request.getSession());
        model.addObject("username", username);
        return model;
    }
}
