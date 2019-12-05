package com.tts.emaillist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {
	
	@Autowired
	private EmailRepository emailrepository;
	
	@GetMapping
	public String index(EmailList emaillist) {
		//Where we want to go when our application is started
		return "emaillist/index";
	}
}
