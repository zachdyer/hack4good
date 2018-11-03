package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.ApplicationRepo;
import com.borrowmyangel.hack4good.dao.UserRepo;
import com.borrowmyangel.hack4good.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        userRepo.save(curAngel); }
}
