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
import com.project.dto.PkrPlayers;
import com.project.repository.Perfect11Repository;
import com.project.service.PkrService;

@Controller
public class PkrController {
	@Autowired
	PkrService service;
	@Autowired
	Perfect11Repository perfectRepo;
	
	@GetMapping("add-pkr-player")
	public String addPkrPlayer() {
		return "addPkrPlayer";
	}
	
	@PostMapping("save-pkr-player")
	public String savePkrPlayer(@ModelAttribute PkrPlayers pkr) {
		service.savePkrPlayer(pkr);
		return "redirect:/get-pkr-details";
	}
	@GetMapping("/get-pkr-details")
	public ModelAndView getPkrDetails() {
		List<PkrPlayers> list = service.getPkrDetails();
		return new ModelAndView("pkrDetails","teams",list);
	}
	@RequestMapping("/update-pkr-player/{id}")
	public String updatePkrPlayer(@PathVariable("id")int id, Model model) {
		PkrPlayers pkrPlayer = service.getPkrPlayerById(id);
		model.addAttribute("player", pkrPlayer);
		return "editPkrPlayer";
	}
	@RequestMapping("/delete-pkr-player/{id}")
	public String deletePkrPlayer(@PathVariable("id")int id) {
		service.deletePkrPlayer(id);
		return "redirect:/get-pkr-details";
	}
	@RequestMapping("/add-pkr-to-perfect11/{id}")
	public String addToPerfect11(@PathVariable("id")int id) {
		PkrPlayers p = service.getPkrPlayerById(id);
		Perfect11 perfect = new Perfect11(p.getId(),p.getPlayerName(),p.getRoll(),p.getNation(),p.getTeams());
		perfectRepo.save(perfect);
		return "redirect:/get-perfect11";
	}
}
