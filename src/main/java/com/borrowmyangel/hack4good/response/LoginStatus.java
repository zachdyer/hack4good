package com.borrowmyangel.hack4good.response;

public class LoginStatus {
	private boolean loggedIn;

	public LoginStatus(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
