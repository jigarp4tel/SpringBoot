package com.jp.reservation.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
	
	
	@GetMapping("/user/signup")
	public String getRegistrationForm() {
		
		return "signup";
	}
	

}
