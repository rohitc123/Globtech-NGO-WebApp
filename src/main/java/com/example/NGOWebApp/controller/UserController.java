package com.example.NGOWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.NGOWebApp.model.User;
import com.example.NGOWebApp.service.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userService;
	
	@GetMapping("/login") 
    public String loginPage() { 
        return "login"; 
    }
	
	
 
//   @PostMapping("/login")
//   public String loginUser(@RequestParam() String username,@RequestParam() String password) {
//	 User user= userService.validateLogin(user)
//	 return "";
//// }
}
