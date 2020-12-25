package com.javalec.ex.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.javalec.ex.beans.BoardBean;
import com.javalec.ex.beans.UserBean;
import com.javalec.ex.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	
	private UserBean checkLoginBean;
	private TopMenuService topMenuService;

	public TopMenuInterceptor(UserBean checkLoginBean, TopMenuService topMenuService){
		this.checkLoginBean = checkLoginBean;
		this.topMenuService = topMenuService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardBean> topMenuInfo = topMenuService.getTopMenuInfo();
		request.setAttribute("topMenuInfo", topMenuInfo);
		request.setAttribute("checkLoginBean", checkLoginBean);
		
		return true;
	}


}
