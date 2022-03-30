package com.javalec.tdl.dto;

public class TDtoM {

	String userId;
	String userName;
	
	public TDtoM () {
		
	}

	public TDtoM(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
