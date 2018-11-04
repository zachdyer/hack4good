package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.LoginRepo;
import com.borrowmyangel.hack4good.dao.SessionRepo;
import com.borrowmyangel.hack4good.dao.UserRepo;
import com.borrowmyangel.hack4good.domain.Login;
import com.borrowmyangel.hack4good.domain.Session;
import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.dto.SessionRequest;
import com.borrowmyangel.hack4good.response.SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    SessionRepo sessionRepo;

    @Autowired
	UserRepo userRepo;

    @Autowired
    AccountService accountService;


    public SessionResponse startSession(SessionRequest sessionRequest, HttpServletRequest request) {
    	// Check the login
        if (accountService.checkLogin(request) == null) {
        	return new SessionResponse(SessionResponse.ResponseStatus.FAILED);
        }

        // Make sure the request is valid
        if (!sessionRequest.isValid()) {
        	return new SessionResponse(SessionResponse.ResponseStatus.FAILED);
        }

        // Get the user and create the session
        User user = accountService.getUserFromToken(request.getHeader("token"));
        Session session = new Session();
        session.setPin(user);
        session.setStatus(Session.Status.WAITING);
        session.setSession_type(sessionRequest.getType());
		sessionRepo.save(session);


		return new SessionResponse(session.getSid(), session.getStatus(), session.getSession_type(), null);
    }

    public SessionResponse checkSessionById(Integer id, HttpServletRequest request) {
    	// Check the login
	    User requestedLogin = accountService.checkLogin(request);
	    if (requestedLogin == null) {
	    	return new SessionResponse(SessionResponse.ResponseStatus.FAILED);
	    }

	    // Check if the ID is null (check it here because Hibernate gets upset if we pass it below)
	    if (id == null) {
	    	return new SessionResponse(SessionResponse.ResponseStatus.FAILED);
	    }

	    // Get the session
    	Optional<Session> session = sessionRepo.findById(id);

    	// Check if the session is there
    	if (!session.isPresent()) {
    		return new SessionResponse(SessionResponse.ResponseStatus.FAILED);
	    }

	    // Get the user of the session and the requesting user
	    User sessionPin = session.get().getPin();
    	User sessionAngel = session.get().getAngel();

    	// Check that either the person in need or the angel made the request
	    if (requestedLogin != sessionPin && requestedLogin != sessionAngel) {
	    	return new SessionResponse(SessionResponse.ResponseStatus.FAILED);
	    }

	    // Return the session info
	    return new SessionResponse(session.get());
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

    	Boolean isAuthenticated = checkForMatch(email, pass);

    	if(isAuthenticated == Boolean.FALSE){
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
    private Boolean checkForMatch (String email, String pass){
    	List<User> users = (List)userRepo.findAll();

		for(User user: users){
			if(user.getEmail().equals(email) && user.getPassword_hash().equals(pass)){
				return Boolean.TRUE;
			}
		}

    	return Boolean.FALSE;
    }

	/**
	 *
	 * @param
	 * @return Cryptic token for authentication
	 */
    public String createLargeString(){

    	String token = "";

    	for (int i = 0; i < 128; i++){
    		int rand = 34 + (int)(Math.random() * ((126 - 34) + 1));

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
