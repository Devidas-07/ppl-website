package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.BsgPlayers;
import com.project.repository.BsgRepository;

@Service
public class BsgService {
	@Autowired
	BsgRepository repo;
	
	public List<BsgPlayers> getBsgDetails(){
		return repo.findAll();
	}
	public void saveBsgPlayer(BsgPlayers player) {
		repo.save(player);
	}
	public BsgPlayers getBsgPlayerById(int id) {
		return repo.findById(id).get();
	}
	public void updateBsgPlayer(BsgPlayers player) {
		repo.save(player);
	}
	public void deleteBsgPlayer(int id) {
		repo.deleteById(id);
	}

}
