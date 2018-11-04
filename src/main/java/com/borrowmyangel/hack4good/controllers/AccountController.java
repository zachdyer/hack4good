package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.domain.Application;
import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.response.LoginStatus;
import com.borrowmyangel.hack4good.response.RegisterResponse;
import com.borrowmyangel.hack4good.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = {"/"})
public class AccountController {

    @Autowired
    AccountService accountService;

	/**
	 *
	 * @param user
	 * @return Register Response containing resulting code
	 */
    @RequestMapping(value="/register", method = RequestMethod.POST)
    @ResponseBody
    public RegisterResponse register(User user) {
	    return accountService.registerUser(user);
    }

	/**
	 *
	 * @param user, application
	 * @return Register Response containing resulting code
	 */
	@RequestMapping(value="/registerWithApplication", method = RequestMethod.POST)
	@ResponseBody
	public RegisterResponse registerWithApplication(User user, Application application) {
		return accountService.registerUserWithApplication(user, application);
	}

	/**
	 *
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/changeAngelStatus", method = RequestMethod.POST)
    public void changeAngelStatus(HttpServletRequest request) {
        accountService.changeAngelStatus(Integer.parseInt(request.getParameter("id")), request.getParameter("status"));
    }

    @RequestMapping(value="/testCreateApplication", method = RequestMethod.GET)
    @ResponseBody
    public User testCreateApplication(HttpServletRequest request) {
        return accountService.testCreateApplication();
    }

	@RequestMapping("/checkLogin")
	@ResponseBody
	public LoginStatus isLoggedIn(HttpServletRequest request) {
		return new LoginStatus(accountService.checkLogin(request) != null);
	}
}
