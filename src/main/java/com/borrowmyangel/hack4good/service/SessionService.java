package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.LoginRepo;
import com.borrowmyangel.hack4good.dao.SessionRepo;
import com.borrowmyangel.hack4good.dao.UserRepo;
import com.borrowmyangel.hack4good.domain.Login;
import com.borrowmyangel.hack4good.domain.Session;
import com.borrowmyangel.hack4good.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SessionService {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    SessionRepo sessionRepo;

    @Autowired
	UserRepo userRepo;

    public void startSession(Integer id) {
        //sessionRepo.startSession(id);
    }

    public String checkSessionById(Integer id) {
        return sessionRepo.findById(id).get().getStatus().toString();
    }

    public Boolean isLoggedIn(Integer id) {
        //return sessionRepo.isLoggedIn(id);
        return null;
    }

    public String login(Integer id, String pass) {
        //return sessionRepo.login(id, pass);
        return null;
    }

    public Login testLogin(){
	    User user = userRepo.findById(1).get();

		Login newLogin = new Login();
		newLogin.setDate_created(Timestamp.from(Instant.now()));
		newLogin.setToken("abcdefg");
		newLogin.setValid(Boolean.TRUE);
		newLogin.setUid(user);

		return newLogin;
    }

	public User testMultipleSessions(){
		User user = userRepo.findById(1).get();

		Session newSession = new Session();
		newSession.setDate_created(Timestamp.from(Instant.now()));
		newSession.setDate_ended(Timestamp.from(Instant.now()));
		newSession.setDate_started(Timestamp.from(Instant.now()));
		newSession.setSession_type(Session.Session_Type.valueOf("TALK"));
		newSession.setStatus(Session.Status.valueOf("FAILED"));
		newSession.setPin(user);

		Session newSession2 = new Session();
		newSession2.setDate_created(Timestamp.from(Instant.now()));
		newSession2.setDate_ended(Timestamp.from(Instant.now()));
		newSession2.setDate_started(Timestamp.from(Instant.now()));
		newSession2.setSession_type(Session.Session_Type.TEXT);
		newSession2.setStatus(Session.Status.CANCELLED);
		newSession2.setPin(user);

		user.setSessions(new ArrayList<Session>() {{ add(newSession); add(newSession2); }});

		return user;
	}

	public User testMultipleLogin(){
		User user = userRepo.findById(1).get();

		Login newLogin = new Login();
		newLogin.setDate_created(Timestamp.from(Instant.now()));
		newLogin.setToken("abcdefg");
		newLogin.setValid(Boolean.TRUE);
		newLogin.setUid(user);

		Login newLogin2 = new Login();
		newLogin2.setDate_created(Timestamp.from(Instant.now()));
		newLogin2.setToken("abcdefghijk");
		newLogin2.setValid(Boolean.TRUE);
		newLogin2.setUid(user);

		user.setLogins(new ArrayList<Login>() {{ add(newLogin); add(newLogin2); }});

		return user;
	}
}
