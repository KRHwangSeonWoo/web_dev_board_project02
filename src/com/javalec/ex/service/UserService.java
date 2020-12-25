package com.javalec.ex.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.ex.beans.UserBean;
import com.javalec.ex.dao.UserDao;

@Service
public class UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Resource(name="checkLoginBean")
	UserBean checkLoginBean;
	
	public boolean checkUserIdExist(String user_id) {
		String user_id_check=userDao.checkUserIdExist(user_id);
		
		if(user_id_check==null) {
			return true;
			
		}else {
			return false;
		}
	}
	
	
	public void joinUser(UserBean userBean) {
		userDao.joinUser(userBean);
	}
	
	public void loginUser(UserBean userBean) {
	UserBean tempUserInfo=userDao.loginUser(userBean);
	
	if(tempUserInfo != null) {
		
		checkLoginBean.setUser_id(tempUserInfo.getUser_id());
		checkLoginBean.setUser_idx(tempUserInfo.getUser_idx());
		checkLoginBean.setUser_name(tempUserInfo.getUser_name());
		checkLoginBean.setUserLogin(true);
	}
	}
	
	
	public void getUserSession(UserBean userBean) {
		userBean.setUser_idx(checkLoginBean.getUser_idx());
		userBean.setUser_id(checkLoginBean.getUser_id());
		userBean.setUser_name(checkLoginBean.getUser_name());
		}
		
 
	public void modifyUser(UserBean userBean) {
		userBean.setUser_idx(checkLoginBean.getUser_idx());
		userDao.modifyUser(userBean);
	}


	public void logout() {
		// TODO Auto-generated method stub
		checkLoginBean.setUserLogin(false);
	}



}
		
	



