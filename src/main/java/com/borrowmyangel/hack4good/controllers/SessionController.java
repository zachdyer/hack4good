package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/"})
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping(value="/session/startSession", method = RequestMethod.POST)
    @ResponseBody
    public void startSession(HttpServletRequest request, Model model) {
        sessionService.startSession(request.getParameter("id"));
    }

    @RequestMapping(value="/session/checkSession", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpServletRequest request, Model model) {
        return sessionService.checkSessionById(request.getParameter("id"));
    }

    @RequestMapping(value="/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkLogin(HttpServletRequest request, Model model) {
        return sessionService.isLoggedIn();
    }
}
