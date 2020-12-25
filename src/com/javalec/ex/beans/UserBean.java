package com.javalec.ex.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {

	@Size(min=2, max=4)
	@Pattern(regexp = "[가-힣]*")
	private String user_name;
	
	@Size(min=4, max=10)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_id;
	
	@Size(min=4, max=10)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;
	
	private String user_pw_check;
	
	private boolean userIdExist;
	
	private boolean userLogin;

	private int user_idx;
	
	public UserBean() {
		this.userIdExist=false;
	}
	
	public int getUser_idx() {
		return user_idx;
	}


	public void setUser_idx(int userIdx) {
		this.user_idx = userIdx;
	}


	public boolean isUserLogin() {
		return userLogin;
	}


	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}



	
	
	public boolean isUserIdExist() {
		return userIdExist;
	}


	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}


	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_pw_check() {
		return user_pw_check;
	}

	public void setUser_pw_check(String user_pw_check) {
		this.user_pw_check = user_pw_check;
	}

	
	

	
	
}
