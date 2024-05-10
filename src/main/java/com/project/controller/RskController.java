package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.Perfect11;
import com.project.dto.RskPlayers;
import com.project.repository.Perfect11Repository;
import com.project.service.RskService;

@Controller
public class RskController {
	
	
	@Autowired
	RskService service;
	@Autowired
	Perfect11Repository perfectRepo;
	
	@GetMapping("/get-rsk-details")
	public ModelAndView getRskDetails() {
		List<RskPlayers> list = service.getRskDetails();
		return new ModelAndView("PlayerList","teams",list);
	}
	@PostMapping("/save-rsk-players")
	public String saveRskPlayers(@ModelAttribute RskPlayers rsk) {
		service.saveRskPlayers(rsk);
		return "redirect:/get-rsk-details";
	}
	@RequestMapping("/update-rsk-players/{id}")
	public String updateRskPlayers(@PathVariable("id") int id, Model model) {
		RskPlayers rskPlayer = service.getRskPlayerById(id);
		model.addAttribute("player",rskPlayer);
		return "editPlayer";
	}	
	@RequestMapping("/delete-rsk-player/{id}")
	public String deleteRskPlayer(@PathVariable("id")int id) {
		service.deleteRskPlayer(id);
		return "redirect:/get-rsk-details";
	}
	@GetMapping("/add-rsk-players")
	public String addRskPlayers() {
		return "addRskPlayers";
	}
	@RequestMapping("/add-rsk-to-perfect11/{id}")
	public String addToPerfect11(@PathVariable("id")int id) {
		RskPlayers p = service.getRskPlayerById(id);
		Perfect11 perfect = new Perfect11(p.getId(),p.getPlayerName(),p.getRoll(),p.getNation(),p.getTeams());
		perfectRepo.save(perfect);
		return "redirect:/get-perfect11";
	}
	

	
	
	
}
