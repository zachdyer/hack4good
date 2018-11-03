package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.ApplicationRepo;
import com.borrowmyangel.hack4good.dao.UserRepo;
import com.borrowmyangel.hack4good.domain.Application;
import com.borrowmyangel.hack4good.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.font.TrueTypeFont;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ApplicationRepo applicationRepo;

    public void registerUser(List<String> values) {
        User newUser = new User();
        userRepo.save(newUser); }

    public void changeAngelStatus(Integer id, String status) {
        User curAngel = userRepo.findById(id).get();

        curAngel.setAngel_status(User.Angel_Status.valueOf(status));

        userRepo.save(curAngel);
    }

    public User testCreateApplication (){
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

        Application app = new Application();
        app.setLname("High");
        app.setAddress("An Address");
        app.setCriminal_history("None");
        app.setPhone("5555555");
        app.setExperience("A little");
        app.setReason("NA");
        app.setVolunteering("A TON");
        app.setRefs("Just the one");
        app.setPermit_bgc(Boolean.TRUE);
        app.setUser(user);

        return app.getUser();
    }
}
