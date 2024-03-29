package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.RskPlayers;
import com.project.repository.RskRepository;

@Service
public class RskService {
	
	@Autowired
	RskRepository repo;
	
	public List<RskPlayers> getRskDetails(){
		return repo.findAll();
	}
	public void saveRskPlayers(RskPlayers rsk) {
		repo.save(rsk);
	}
	public void updateRskPlayers(RskPlayers rsk) {
		repo.save(rsk);
	}
	public void deleteRskPlayer(int id) {
		repo.deleteById(id);
	}
	public RskPlayers getRskPlayerById(int id) {
		return repo.findById(id).get();
	}
}
