package com.borrowmyangel.hack4good.dto;

import com.borrowmyangel.hack4good.domain.Session;

public class SessionRequest {
	Session.Session_Type type;

	public SessionRequest() {
	}

	public SessionRequest(Session.Session_Type type) {
		this.type = type;
	}

	public Session.Session_Type getType() {
		return type;
	}

	public void setType(Session.Session_Type type) {
		this.type = type;
	}

	public boolean isValid() {
		return type != null;
	}
}
