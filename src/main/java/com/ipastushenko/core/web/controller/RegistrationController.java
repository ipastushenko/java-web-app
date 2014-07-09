package com.ipastushenko.core.web.controller;

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
        return new ModelAndView("auth/send-confirm-info");
    }
}
