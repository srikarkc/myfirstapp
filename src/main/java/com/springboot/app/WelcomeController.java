package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {
 @GetMapping("/welcome")
	public String welcome() {
	 return "Hello World! Made for Angi by Srikar KC.";
 }
	public String first_feature() {
	 return "This is my awesome feature 1.";
 }
}
