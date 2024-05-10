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

import com.project.dto.PcPlayers;
import com.project.dto.Perfect11;
import com.project.repository.Perfect11Repository;
import com.project.service.PcService;

@Controller
public class PcController {
@Autowired
PcService service;
@Autowired
Perfect11Repository perfectRepo;

	@GetMapping("/add-pc-player")
	public String addPcPlayer() {
		return "addPcPlayer";
	}

	@PostMapping("/save-pc-player")
	public String savePcPlayer(@ModelAttribute PcPlayers pc) {
		service.savePcPlayers(pc);
		return "redirect:/get-pc-details";
	}
	@GetMapping("/get-pc-details")
	public ModelAndView getPcDetails() {
		List<PcPlayers> list= service.getPcDetails();
		return new ModelAndView("pcDetails","teams",list);
	}
	@RequestMapping("/update-pc-player/{id}")
	public String updatePcPlayer(@PathVariable("id") int id, Model model) {
		PcPlayers pcPlayer = service.getPcPlayerById(id);
		model.addAttribute("player", pcPlayer);
		return "editPcPlayer";		
	}
	@RequestMapping("/delete-pc-player/{id}")
	public String deletePcPlayer(@PathVariable("id")int id) {
		
		service.deletePcPlayer(id);
		return "redirect:/get-pc-details";
	}
	@RequestMapping("/add-pc-to-perfect11/{id}")
	public String addToPerfect11(@PathVariable("id")int id) {
		PcPlayers p = service.getPcPlayerById(id);
		Perfect11 perfect = new Perfect11(p.getId(),p.getPlayerName(),p.getRoll(),p.getNation(),p.getTeams());
		perfectRepo.save(perfect);
		return "redirect:/get-perfect11";
	}
	
}
