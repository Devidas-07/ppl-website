package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.PcPlayers;
import com.project.repository.PcRepository;

@Service
public class PcService {
	@Autowired
	PcRepository repo;
	
	public void savePcPlayers(PcPlayers pc) {
		repo.save(pc);
	}
	public List<PcPlayers> getPcDetails(){
		return repo.findAll();
	}
	public PcPlayers getPcPlayerById(int id) {
		return repo.findById(id).get();
	}
	public void updatePcPlayer(PcPlayers pc) {
		repo.save(pc);
	}
	public void deletePcPlayer(int id) {
		repo.deleteById(id);
	}
}
