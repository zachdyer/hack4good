package com.borrowmyangel.hack4good.service;

import com.borrowmyangel.hack4good.dao.ApplicationRepo;
import com.borrowmyangel.hack4good.dao.LoginRepo;
import com.borrowmyangel.hack4good.dao.UserRepo;
import com.borrowmyangel.hack4good.domain.Application;
import com.borrowmyangel.hack4good.domain.Login;
import com.borrowmyangel.hack4good.domain.User;
import com.borrowmyangel.hack4good.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AccountService {
	@Autowired
	LoginRepo loginRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ApplicationRepo applicationRepo;

	/**
	 *
	 * @param user
	 * @return
	 */
	public RegisterResponse registerUser(User user) {
    	user.setAccount_type(User.Account_Type.PERSON_IN_NEED);
    	user.setState("MO");
    	user.setCity("Springfields");
    	user.setAge(20);
    	// user.setGender(User.Gender.MALE);
    	user.setPassword_hash("somehash");
    	user.setAngel_status(User.Angel_Status.AVAILABLE);
        userRepo.save(user);
        return new RegisterResponse(0);
    }

    public void changeAngelStatus(Integer id, String status) {
        User curAngel = userRepo.findById(id).get();

        curAngel.setAngel_status(User.Angel_Status.valueOf(status));

        userRepo.save(curAngel);
    }

    public User testCreateApplication (){
        User user = userRepo.findById(1).get();

        Application app = new Application();
        app.setLname("High");
        app.setAddress("An Address");
        app.setCriminal_history("None");
        app.setPhone("5555555");
        app.setExperience("A little");
        app.setReason("NA");
        app.setVolunteering("A TON");
        app.setRefs("Just the one");
        app.setPermit_background_check(Boolean.TRUE);
        app.setUser(user);

        applicationRepo.save(app);

        return app.getUser();
    }

	public boolean checkLogin(HttpServletRequest request) {
		String token = request.getHeader("token");

		// Make sure the token is even set
		if (token == null || token.trim().equals("")) {
			return false;
		}

		// Get the matching login, if any
		Login login = loginRepo.getByToken(token);

		// Check if the login exists and is valid
		return login != null && login.getValid();
	}
}
