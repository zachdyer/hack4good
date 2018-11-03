package com.borrowmyangel.hack4good.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/"})
public class AccountController {

    @RequestMapping("/register")
    public void register(HttpServletRequest request, Model model) {

    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request, Model model) {

    }
}
