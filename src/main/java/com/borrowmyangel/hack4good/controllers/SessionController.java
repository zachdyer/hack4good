package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.domain.Login;
import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.dto.SessionRequest;
import com.borrowmyangel.hack4good.response.SessionResponse;
import com.borrowmyangel.hack4good.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping(value = {"/"})
public class SessionController {


    @Autowired
    SessionService sessionService;

	/**
	 * Start a session
	 *
	 * @param sessionRequest
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/session/startSession", method = RequestMethod.POST)
    @ResponseBody
    public SessionResponse startSession(SessionRequest sessionRequest, HttpServletRequest request) {
	    return sessionService.startSession(sessionRequest, request);
    }

	/**
	 * Check the status of a session with specified ID
	 *
	 * @param request
	 * @return Session status
	 */
    @RequestMapping(value="/session/checkSession", method = RequestMethod.GET)
    @ResponseBody
    public SessionResponse getSession(@RequestParam(required = false) Integer id, HttpServletRequest request) {
        return sessionService.checkSessionById(id, request);
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
    public ArrayList<String> login(HttpServletRequest request) {
        String token = sessionService.login(request.getParameter("email"), request.getParameter("password"));
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
