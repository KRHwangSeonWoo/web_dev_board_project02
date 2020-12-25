package com.javalec.ex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javalec.ex.beans.UserBean;
import com.javalec.ex.mapper.UserMapper;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public String checkUserIdExist(String user_id) {
		return userMapper.checkUserIdExist(user_id);
	}
	
	public void joinUser(UserBean userBean) {
		 userMapper.joinUser(userBean);
	}
	
	public UserBean loginUser(UserBean userBean) {
		return userMapper.loginUser(userBean);
	}
	
	public void modifyUser(UserBean userBean) {
		 userMapper.modifyUser(userBean);
	}
	
}
