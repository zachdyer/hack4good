package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.response.LoginStatus;
import com.borrowmyangel.hack4good.response.RegisterResponse;
import com.borrowmyangel.hack4good.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/"})
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    @ResponseBody
    public RegisterResponse register(User user, Model model) {
	    return accountService.registerUser(user);
    }

    @RequestMapping(value="/changeAngelStatus", method = RequestMethod.POST)
    public void changeAngelStatus(HttpServletRequest request, Model model) {
        accountService.changeAngelStatus(Integer.parseInt(request.getParameter("id")), request.getParameter("status"));
    }

    @RequestMapping(value="/testCreateApplication", method = RequestMethod.GET)
    @ResponseBody
    public User testCreateApplication(HttpServletRequest request, Model model) {
        return accountService.testCreateApplication();
    }

	@RequestMapping("/checkLogin")
	@ResponseBody
	public LoginStatus isLoggedIn(HttpServletRequest request) {
		return new LoginStatus(accountService.checkLogin(request));
	}
}
