package com.ipastushenko.core.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * home controller
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
