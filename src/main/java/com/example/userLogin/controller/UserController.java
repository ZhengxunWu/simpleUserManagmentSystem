package com.example.userLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.userLogin.user.User;
import com.example.userLogin.userRepository.UserRepository;

@RestController
public class UserController {
	
	//model: user,praise,paste
	//view: .jsp .html
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/index.action")
	public ModelAndView index() {
		return new ModelAndView("/index.html");
	}
	@RequestMapping("/user/register.action")
	public ModelAndView register(User user) {
		System.out.println(user.getUsername()+"///"+user.getPassword());
		userRepository.save(user);
		System.out.println("register called");
		return new ModelAndView("redirect:/index.action");
	}
	@RequestMapping("/user/login.action")
	public ModelAndView login(User user) {
		User loginUser=userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(loginUser==null) {
			return new ModelAndView("redirect:/index.action");
			
		}else {
			return new ModelAndView("/welcome.html");
		}
			
			
		
	}

}
