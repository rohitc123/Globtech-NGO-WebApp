package com.example.NGOWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.NGOWebApp.model.Role;
import com.example.NGOWebApp.model.User;
import com.example.NGOWebApp.service.UserService;




@Controller
public class RegisterController {

	@Autowired
    private UserService userService;
	
	
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestParam() String username,@RequestParam() String password,@RequestParam() Role role) {
		userService.saveUser(username,password,role);
		return "redirect:/login";
	}
	
}
