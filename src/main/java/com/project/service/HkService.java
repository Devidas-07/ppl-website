package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.HkPlayers;
import com.project.repository.HkRepository;

@Service
public class HkService {

	@Autowired
	HkRepository repo;
	
	public void saveHkPlayer(HkPlayers player) {
		repo.save(player);
	}
}
