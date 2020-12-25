package com.javalec.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.javalec.ex.beans.UserBean;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(HttpServletRequest request) {
		System.out.println(request.getServletContext().getRealPath("/"));
		return "board/main";
	}
	
	
}
