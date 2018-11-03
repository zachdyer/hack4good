package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.LoginRepo;
import com.borrowmyangel.hack4good.dao.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService{

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    SessionRepo sessionRepo;

    public void startSession(Integer id) { return sessionRepo.startSession(id); }

    public String checkSessionById(Integer id) { return sessionRepo.checkSessionById(id); }

    public Boolean isLoggedIn(Integer id) { return sessionRepo.isLoggedIn(id); }

    public String login(Integer id, String pass) { return sessionRepo.login(id, pass); }

}
