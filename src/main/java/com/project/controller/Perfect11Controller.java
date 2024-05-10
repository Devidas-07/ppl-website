package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.Perfect11;
import com.project.repository.Perfect11Repository;

@Controller
public class Perfect11Controller {
	@Autowired
	Perfect11Repository perfectRepo;
	@GetMapping("get-perfect11")
	public ModelAndView getPerfect11() {
		List<Perfect11> list = perfectRepo.findAll();
		return new ModelAndView("perfect11","perfect11",list);
	}
}
