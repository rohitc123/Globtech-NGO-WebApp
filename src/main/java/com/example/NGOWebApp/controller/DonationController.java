package com.example.NGOWebApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonationController {

	@PreAuthorize("isAuthenticated()") 
	@GetMapping("/donate")
	public String donatioPage() {
		return "Donate";
	}
}
