package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.LoginRepo;
import com.borrowmyangel.hack4good.dao.SessionRepo;
import com.borrowmyangel.hack4good.dao.UserRepo;
import com.borrowmyangel.hack4good.domain.Login;
import com.borrowmyangel.hack4good.domain.Session;
import com.borrowmyangel.hack4good.domain.User;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.round;

@Service
public class SessionService {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    SessionRepo sessionRepo;

    @Autowired
	UserRepo userRepo;


	/**
	 *
	 * @param id
	 * @return
	 */
    public void startSession(Integer id) {
        //sessionRepo.startSession(id);
    }

	/**
	 *
	 * @param id
	 * @return Status of session
	 */
    public String checkSessionById(Integer id) {
        return sessionRepo.findById(id).get().getStatus().toString();
    }

	/**
	 *
	 * @param token
	 * @return True or false
	 */
    public Boolean isLoggedIn(String token) {
    	List<Login> logs = (List)loginRepo.findAll();
	    for (Login log : logs) {
		    if(log.getToken() == token){
		    	return true;
		    }
	    }
        return false;
    }

	/**
	 *
	 * @param email, pass
	 * @return token assigned to user for authentication
	 */
    public String login(String email, String pass) {

    	if(!isAutenticated(email, pass)){
    		return "FAILED";
	    }

	    List<User> users = (List)userRepo.findAll();
    	User user = new User();

	    for(User u: users){
		    if(u.getEmail().equals(email)){
			    user = u;
		    }
	    }

	    String token = createLargeString();

	    Login login = new Login();

	    login.setValid(Boolean.TRUE);
	    login.setUid(user);
	    login.setToken(token);
	    login.setDate_created(Timestamp.from(Instant.now()));

	    loginRepo.save(login);

        return token;
    }

	/**
	 *
	 * @param email, pass
	 * @return True or False
	 */
    private Boolean isAutenticated (String email, String pass){
    	List<User> users = (List)userRepo.findAll();

		for(User user: users){
			if(user.getEmail() == email && user.getPassword_hash() == pass){
				return true;
			}
		}

    	return false;
    }

	/**
	 *
	 * @param
	 * @return Cryptic token for authentication
	 */
    public String createLargeString(){

    	String token = "";

    	for (int i = 0; i < 128; i++){
    		int rand = (int)round((Math.random() * ((126 - 34) + 1)) + 34);

			token += Character.toString((char)rand);
	    }

	    return token;
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

		user.setSessionsInitiated(new ArrayList<Session>() {{ add(newSession); add(newSession2); }});

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
