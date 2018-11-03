package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.ApplicationRepo;
import com.borrowmyangel.hack4good.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ApplicationRepo applicationRepo;

    void registerUser(List<String> values) { userRepo.registerUser(values); }

    void changeAngelStatus(Integer id, String status) { userRepo.changeStatus(id, status); }
}
