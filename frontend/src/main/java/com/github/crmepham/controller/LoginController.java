package com.github.crmepham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Serves the login web view.
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public String login(final Model model) {
        return "login";
    }
}
