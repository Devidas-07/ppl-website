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

import com.project.dto.BsgPlayers;
import com.project.dto.Perfect11;
import com.project.repository.Perfect11Repository;
import com.project.service.BsgService;

@Controller
public class BsgController {
	@Autowired
	BsgService service;
	@Autowired
	Perfect11Repository perfectRepo;
	
	@GetMapping("/get-bsg-details")
	public ModelAndView getBsgails() {
		List<BsgPlayers> list = service.getBsgDetails();
		return new ModelAndView("bsgDetails","teams",list);
	}
	@PostMapping("/save-bsg-players")
	public String saveRskPlayers(@ModelAttribute BsgPlayers player) {
		service.saveBsgPlayer(player);
		return "redirect:/get-bsg-details";
	}
	@RequestMapping("/update-bsg-players/{id}")
	public String updateBsgPlayers(@PathVariable("id") int id, Model model) {
		BsgPlayers player = service.getBsgPlayerById(id);
		model.addAttribute("player",player);
		return "editBsg";
	}	
	@RequestMapping("/delete-bsg-player/{id}")
	public String deleteBsgPlayer(@PathVariable("id")int id) {
		service.deleteBsgPlayer(id);
		return "redirect:/get-rsk-details";
	}
	@GetMapping("/add-bsg-player")
	public String addBsgPlayer() {
		return "addBsgPlayer";
	}
	@RequestMapping("/add-bsg-to-perfect11/{id}")
	public String addToPerfect11(@PathVariable("id")int id) {
		BsgPlayers p = service.getBsgPlayerById(id);
		Perfect11 perfect = new Perfect11(p.getId(),p.getPlayerName(),p.getRoll(),p.getNation(),p.getTeams());
		perfectRepo.save(perfect);
		return "redirect:/get-perfect11";
	}

	
	
	
}
