package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
	public String test() {
		User user = new User();
		user.setAccount_type(User.Account_Type.ADMIN);
		user.setAge(10);
		user.setAngel_status(User.Angel_Status.DND);
		user.setCity("Sprisngbutt");
		user.setState("AK");
		user.setDate_created(Timestamp.from(Instant.now()));
		user.setFname("Somdeone");
		user.setEmail("Emaaaaadil");
		user.setGender(User.Gender.FEMALE);
		user.setUsername("heckle");
		user.setPassword_hash("sudnhvcuewhvcer");
		user.setNickname("SOIUrewr");
		dao.save(user);
		return "done";
	}

	@RequestMapping(value = "/test2")
	@ResponseBody
	public String test2(HttpServletRequest request) {
		return request.getHeader("token");
	}


}
