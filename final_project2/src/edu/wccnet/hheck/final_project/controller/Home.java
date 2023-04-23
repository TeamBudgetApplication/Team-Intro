package edu.wccnet.hheck.final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.wccnet.hheck.final_project.service.CustomerService;

@Controller
public class Home {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("customers",customerService.getCustomers());
		return "home";
	}
}