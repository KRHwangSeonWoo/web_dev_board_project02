package com.javalec.ex.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.javalec.ex.beans.UserBean;


public class CheckLoginInterceptor implements HandlerInterceptor {
	//checkLoginBean
	
	
private UserBean checkLoginBean;
	
	public CheckLoginInterceptor(UserBean checkLoginBean) {
		// TODO Auto-generated constructor stub
		this.checkLoginBean = checkLoginBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if(checkLoginBean.isUserLogin() == false) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_access");
			return false;
		}
		return true;
	}

}
