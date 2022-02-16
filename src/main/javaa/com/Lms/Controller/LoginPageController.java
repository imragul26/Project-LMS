package com.Lms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

	@GetMapping("/myCustomLogin")
	public String loginMethod() {
		
		return "Login-Page";
	}
	
}
