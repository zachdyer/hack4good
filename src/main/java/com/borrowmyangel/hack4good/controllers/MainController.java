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
import java.util.Map;

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

	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	@ResponseBody
	public String test3(HttpServletRequest request) {
		Map<String, String[]> params = request.getParameterMap();
		for (String key: params.keySet()) {
			System.out.print(key + ": ");
			for (int i = 0; i < params.get(key).length; i++) {
				System.out.print(params.get(key)[i] + ",");
			}
			System.out.println(";");
		}
		return "{'message': 'yeet'}";
	}
}
