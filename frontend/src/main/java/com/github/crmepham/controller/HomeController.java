package com.github.crmepham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Serves the 'home' or default landing page, after
 * successful user login.
 */
@Controller
@RequestMapping({"/","home"})
public class HomeController {

    @GetMapping
    public String home(final Model model) {
        return "home";
    }
}
