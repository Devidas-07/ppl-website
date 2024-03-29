package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.HkPlayers;
import com.project.service.HkService;

@RestController
public class HkController {

	@Autowired
	HkService service;
	
	@PostMapping("/save-hk-players")
	public String saveHkPlayer(@RequestBody HkPlayers player) {
		service.saveHkPlayer(player);
		return "player saved succesfully";
		
	}
	@GetMapping("/add-hk-player")
	public String addHkPlayer() {
		return "addHkPlayers";
	}
}
