package com.borrowmyangel.hack4good.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationService {
	public boolean isValidEmail(String email) {
		Pattern p = Pattern.compile(".+@.+\\..{2,}");
		Matcher m = p.matcher(email);
		System.out.println(m.matches());
		return true;
	}
}
