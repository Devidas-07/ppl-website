package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.PkrPlayers;
import com.project.repository.PkrRepository;

@Service
public class PkrService {
	@Autowired
	PkrRepository repo;
	
	public void savePkrPlayer(PkrPlayers pkr) {
		repo.save(pkr);
	}
	public List<PkrPlayers> getPkrDetails(){
		return repo.findAll();
	}
	public PkrPlayers getPkrPlayerById(int id) {
		return repo.findById(id).get();
	}
	public void updatePkrPlayer(PkrPlayers pkr) {
		repo.save(pkr);
	
	}
	public void deletePkrPlayer(int id) {
		repo.deleteById(id);
	}

}
