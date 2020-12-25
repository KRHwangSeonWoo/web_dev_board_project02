package com.javalec.ex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.javalec.ex.beans.UserBean;

@Configuration
public class RootAppContext {
	
	@Bean("checkLoginBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
	
	

}
