package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PplController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/venue")
	public String venuePage() {
		return "venue";
	}
	@GetMapping("/about")
	public String aboutPage() {
		return "aboutUs";
	}
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	@GetMapping("/team")
	public String teamPage() {
		return "team";
	}
}
//INSERT INTO teams (captain,coach,name,owner,venue,winyears) VALUES ('RUSHIKESH SHINDE','MAHESH KHAMKAR','HANGA KINGS','HINDAVI VICHARDHARA HANGA','HADKI STADIUM','2019');
