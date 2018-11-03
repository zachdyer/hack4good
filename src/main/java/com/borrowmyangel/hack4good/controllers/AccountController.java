package com.borrowmyangel.hack4good.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/"})
public class AccountController {

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public void register() {

    }

    @RequestMapping(value="/login")
    public void login(HttpServletRequest request, Model model) {

    }

    @RequestMapping(value="/changeStatus", method = RequestMethod.POST)
    public void changeStatus(HttpServletRequest request, Model model) {

    }
}
