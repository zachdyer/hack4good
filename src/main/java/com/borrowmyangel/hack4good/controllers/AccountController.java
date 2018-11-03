package com.borrowmyangel.hack4good.controllers;

import com.borrowmyangel.hack4good.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/"})
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request, Model model) {

        Map<String,String[]> parameters = request.getParameterMap();
        List<String> values = new ArrayList<>();
        for(String key : parameters.keySet()){
            values.add(key);
        }

        try{
            accountService.registerUser(values);
            return "Successfully registered";
        }catch(Exception e){
            return "Failed to Register";
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public List<String> login(HttpServletRequest request, Model model) {
        String token = accountService.login(request.getParameter("identifier"), request.getParameter("password"));
        return new ArrayList<>("Successful", token);
    }

    @RequestMapping(value="/changeStatus", method = RequestMethod.POST)
    public void changeStatus(HttpServletRequest request, Model model) {

    }
}
