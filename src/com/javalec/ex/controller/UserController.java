package com.javalec.ex.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.ex.beans.UserBean;
import com.javalec.ex.service.UserService;
import com.javalec.ex.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@Resource(name="checkLoginBean")
	UserBean checkLoginBean;
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean userBean) {
		return "user/join";
	}
	
	
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean userBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}
		userService.joinUser(userBean);
		return "user/join_success";
	}
	
		
	@PostMapping("/login_pro")
	public String login(@ModelAttribute("userBean") UserBean userBean) {

		userService.loginUser(userBean);
		
		if(checkLoginBean.isUserLogin() == true ) {
			return "user/login_success";
		}
		return "user/login_fall";
		
	}
	
	@GetMapping("/userInfoModify")
	public String userInfoModify(@ModelAttribute("userBean") UserBean userBean) {
		userService.getUserSession(userBean);
		return "user/userInfoModify";
	}
	
	@PostMapping("/userInfoModify_pro")
	public String userInfoModify(@Valid @ModelAttribute("userBean") UserBean userBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/userInfoModify";
		}
		userService.modifyUser(userBean);
		return "user/userInfoModify_success";
	}
	
	@GetMapping("/logout")
	public String logout() {
		userService.logout();
		return "board/main";
	}
	
	@GetMapping("/not_access")
	public String not_access(){
		return "user/not_access";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
	}
	
}
