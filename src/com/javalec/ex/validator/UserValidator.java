package com.javalec.ex.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.javalec.ex.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		UserBean userBean = (UserBean)target;
		
		String objName=errors.getObjectName();
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw_check()) == false){
			errors.rejectValue("user_pw_check", "NotEquals");
		}
	
		if(objName.equals("joinUserBean")){
		if(userBean.isUserIdExist()==false) {
			errors.rejectValue("user_id", "CheckUserIdIsFalse");
		}
		}
	}

}
