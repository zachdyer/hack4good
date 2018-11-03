package com.borrowmyangel.hack4good.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/"})
public class AuthenicationController {

    @RequestMapping("/isLoggedIn")
    public String isLoggedIn(HttpServletRequest request, Model model) {
        return null;
    }

}
