package com.ipastushenko.core.web.controller;

import com.ipastushenko.core.model.UserDetailsImpl;
import com.ipastushenko.core.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * home controller
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("index");
        UserDetailsImpl userDetails = SessionUtils.getCurrentUserDetails(request.getSession());
        model.addObject("username", userDetails.getUsername());
        model.addObject("ip", userDetails.getLastIp());
        return model;
    }
}
