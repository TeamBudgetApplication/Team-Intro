package edu.wccnet.hheck.budget_draft.controller;

public class MyAPIErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	
	public MyAPIErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public MyAPIErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
