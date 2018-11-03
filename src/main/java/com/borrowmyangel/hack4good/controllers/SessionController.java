package com.borrowmyangel.hack4good.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/"})
public class SessionController {

    @RequestMapping(value="/startSession", method = RequestMethod.POST)
    public void startSession(HttpServletRequest request, Model model) {

    }

    @RequestMapping(value="/checkSession", method = RequestMethod.GET)
    public void getSession(HttpServletRequest request, Model model) {

    }
}
