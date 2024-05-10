package com.project.service;

import java.util.List;

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
	public List<HkPlayers> getHkDetails(){
		return repo.findAll();
	}
	public HkPlayers getHkPlayerById(int id) {
		return repo.findById(id).get();
	}
	public void updateHkPlayer(HkPlayers player) {
		repo.save(player);
	}
	public void deleteHkPlayer(int id) {
		repo.deleteById(id);
	}
}
