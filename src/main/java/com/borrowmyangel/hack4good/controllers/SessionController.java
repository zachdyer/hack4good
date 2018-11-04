package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.domain.Login;
import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.dto.LoginUpload;
import com.borrowmyangel.hack4good.service.SessionService;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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

	/**
	 *
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/session/startSession", method = RequestMethod.POST)
    @ResponseBody
    public void startSession(HttpServletRequest request) {
        sessionService.startSession(Integer.parseInt(request.getParameter("id")));
    }

	/**
	 *
	 * @param request
	 * @return Session status
	 */
    @RequestMapping(value="/session/checkSession", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpServletRequest request) {
        return sessionService.checkSessionById(Integer.parseInt(request.getParameter("id")));
    }

	/**
	 *
	 * @param request
	 * @return True or False
	 */
    @RequestMapping(value="/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public Boolean checkLogin(HttpServletRequest request) {
        return sessionService.isLoggedIn(request.getParameter("token"));
    }

	/**
	 *
	 * @param request
	 * @return Result string and token
	 */
    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<String> login(LoginUpload login) {
        String token = sessionService.login(login.getEmail(), login.getPassword());
        return new ArrayList<String>() {{ add("Successful"); add(token); }};
    }

	@RequestMapping(value="/testLogin", method = RequestMethod.GET)
	@ResponseBody
	public Login testLogin(HttpServletRequest request) {
		return sessionService.testLogin();
	}

	@RequestMapping(value="/testMultipleLogin", method = RequestMethod.GET)
	@ResponseBody
	public User testMultipleLogin(HttpServletRequest request) {
		return sessionService.testMultipleLogin();
	}

	@RequestMapping(value="/testMultipleSessions", method = RequestMethod.GET)
	@ResponseBody
	public User testMultipleSessions(HttpServletRequest request) {
		return sessionService.testMultipleSessions();
	}

	@RequestMapping(value="/testLoginWithRandomToken", method = RequestMethod.GET)
	@ResponseBody
	public String testLoginWithRandomToken(HttpServletRequest request) {
		return sessionService.login("Emaaaaadil","sudnhvcuewhvcer");
	}

}
