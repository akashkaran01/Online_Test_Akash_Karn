package com.capgemini.project.dto;

import java.io.Serializable;

public class User implements Serializable{
	
	private int userid ;
	private String userPassword ;
	
	public User(int userid, String userPassword) {
		this.userid = userid;
		this.userPassword = userPassword;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/*
	 * @Override public String toString() { return "User [userid=" + userid +
	 * ", userPassword=" + userPassword + "]"; }
	 */
	
}
	
	
