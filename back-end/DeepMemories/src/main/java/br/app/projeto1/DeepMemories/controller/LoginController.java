       package br.app.projeto1.DeepMemories.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return"login";
		
	}
	
	@GetMapping("/CreateAccount")
	public String CreateAccount() {
		return "CreateAccount";
	}

}