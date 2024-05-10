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

import com.project.dto.HkPlayers;
import com.project.dto.Perfect11;
import com.project.repository.Perfect11Repository;
import com.project.service.HkService;

@Controller
public class HkController {

	@Autowired
	HkService service;
	@Autowired
	Perfect11Repository perfectRepo;
	
	@PostMapping("/save-hk-players")
	public String saveHkPlayer(@ModelAttribute HkPlayers player) {
		service.saveHkPlayer(player);
		return "redirect:/get-hk-details";
		
	}
	@GetMapping("/add-hk-player")
	public String addHkPlayer() {
		return "addHkPlayers";
	}
	@GetMapping("/get-hk-details")
	public ModelAndView getHkDetails() {
		List<HkPlayers> list=  service.getHkDetails();
		return new ModelAndView("hkDetails","teams",list);
	}
	@RequestMapping("/update-hk-player/{id}")
	public String updateHkPlayer(@PathVariable("id") int id, Model model) {
		HkPlayers player = service.getHkPlayerById(id);
		model.addAttribute("player", player);
		return "editHkPlayer";
	}
	@RequestMapping("/delete-hk-player/{id}")
	public String deleteHkPlayer(@PathVariable("id") int id) {
		service.deleteHkPlayer(id);
		return "redirect:/get-hk-details";
	}
	@RequestMapping("/add-hk-to-perfect11/{id}")
	public String addToPerfect11(@PathVariable("id")int id) {
		HkPlayers p = service.getHkPlayerById(id);
		Perfect11 perfect = new Perfect11(p.getId(),p.getPlayerName(),p.getRoll(),p.getNation(),p.getTeams());
		perfectRepo.save(perfect);
		return "redirect:/get-perfect11";
	}
	
}
