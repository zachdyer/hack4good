package com.borrowmyangel.hack4good.response;

import com.borrowmyangel.hack4good.domain.Session;

public class SessionResponse {
	private ResponseStatus responseStatus;
	private int sessionId;
	private Session.Status status;
	private Session.Session_Type type;
	private String connectionInfo;

	public SessionResponse(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public SessionResponse(int sessionId, Session.Status status, Session.Session_Type type, String connectionInfo) {
		this.responseStatus = ResponseStatus.SUCCESS;
		this.sessionId = sessionId;
		this.status = status;
		this.type = type;
		this.connectionInfo = connectionInfo;
	}

	public SessionResponse(Session session) {
		this.responseStatus = ResponseStatus.SUCCESS;
		this.sessionId = session.getSid();
		this.status = session.getStatus();
		this.type = session.getSession_type();
		this.connectionInfo = null;
	}

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public Session.Status getStatus() {
		return status;
	}

	public void setStatus(Session.Status status) {
		this.status = status;
	}

	public Session.Session_Type getType() {
		return type;
	}

	public void setType(Session.Session_Type type) {
		this.type = type;
	}

	public String getConnectionInfo() {
		return connectionInfo;
	}

	public void setConnectionInfo(String connectionInfo) {
		this.connectionInfo = connectionInfo;
	}

	public enum ResponseStatus {
		SUCCESS(0), FAILED(1);

		int code;

		ResponseStatus(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}
}
