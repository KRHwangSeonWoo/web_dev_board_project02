package com.javalec.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.javalec.ex.beans.UserBean;

public interface UserMapper {

	@Select("select user_id "+
			"from user_table "+
			"where user_id = #{user_id}")
	String checkUserIdExist(String user_id);


	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) "+
			"values (user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void joinUser(UserBean userBean);

	
	@Select("select user_idx, user_name, user_id " + 
			"from user_table " + 
			"where user_id=#{user_id} and user_pw=#{user_pw}")
	UserBean loginUser(UserBean userBean);
	
	@Update("Update user_table "+
			"set user_pw = #{user_pw} "+
			"where user_idx = #{user_idx}")
	void modifyUser(UserBean userBean);
	
}
