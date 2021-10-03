package com.springsecutiry.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String shoeMyLoginPage() {
		//return "plain-login";
		return "fancy-login";
	}
}
