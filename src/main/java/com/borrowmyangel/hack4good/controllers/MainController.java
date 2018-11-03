package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping(value = {"/"})
public class MainController {
	@Autowired
	UserDao dao;

	@RequestMapping(value = {"/", ""})
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public List<User> test() {
		return (List<User>) dao.findAll();
	}

	@RequestMapping(value = "/test2")
	@ResponseBody
	public String test2(HttpServletRequest request) {
		return request.getHeader("token");
	}

	@RequestMapping(value = "/test3")
	@ResponseBody
	public String test3(HttpServletResponse response) {
		return "test";
	}
}
