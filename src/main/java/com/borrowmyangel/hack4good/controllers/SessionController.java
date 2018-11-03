package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.domain.Login;
import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/"})
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping(value="/session/startSession", method = RequestMethod.POST)
    @ResponseBody
    public void startSession(HttpServletRequest request, Model model) {
        sessionService.startSession(Integer.parseInt(request.getParameter("id")));
    }

    @RequestMapping(value="/session/checkSession", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpServletRequest request, Model model) {
        return sessionService.checkSessionById(Integer.parseInt(request.getParameter("id")));
    }

    @RequestMapping(value="/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkLogin(HttpServletRequest request, Model model) {
        return sessionService.isLoggedIn(Integer.parseInt(request.getParameter("id")));
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<String> login(HttpServletRequest request, Model model) {
        String token = sessionService.login(Integer.parseInt(request.getParameter("identifier")), request.getParameter("password"));
        return new ArrayList<String>() {{ add("Successful"); add(token); }};
    }

	@RequestMapping(value="/testLogin", method = RequestMethod.GET)
	@ResponseBody
	public Login testLogin(HttpServletRequest request, Model model) {
		return sessionService.testLogin();
	}

	@RequestMapping(value="/testMultipleLogin", method = RequestMethod.GET)
	@ResponseBody
	public User testMultipleLogin(HttpServletRequest request, Model model) {
		return sessionService.testMultipleLogin();
	}

	@RequestMapping(value="/testMultipleSessions", method = RequestMethod.GET)
	@ResponseBody
	public User testMultipleSessions(HttpServletRequest request, Model model) {
		return sessionService.testMultipleSessions();
	}

}
