package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.response.LoginStatus;
import com.borrowmyangel.hack4good.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = {"/"})
public class AuthenicationController {
    @Autowired
    SessionService sessionService;



}
