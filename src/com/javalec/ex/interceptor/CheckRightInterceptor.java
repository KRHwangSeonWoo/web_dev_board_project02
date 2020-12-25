package com.javalec.ex.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import com.javalec.ex.beans.UserBean;

public class CheckRightInterceptor implements HandlerInterceptor{

	private UserBean checkLoginBean;
	
	public CheckRightInterceptor(UserBean checkLoginBean) {
		this.checkLoginBean=checkLoginBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		int content_idx= Integer.parseInt((String) request.getParameter("content_idx"));
		int writer_idx= Integer.parseInt((String) request.getParameter("writer_idx"));
		if(checkLoginBean.getUser_idx()!=writer_idx) {
			String contextPath = request.getContextPath();
			try {
				response.sendRedirect(contextPath+"/board/not_right?content_idx="+content_idx);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	
}
