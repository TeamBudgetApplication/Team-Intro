package edu.wccnet.hheck.budget_draft.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.hheck.budget_draft.entity.Customer;
import edu.wccnet.hheck.budget_draft.service.CustomerService;

@Controller
@RequestMapping("/login")
public class MainController {
	
	@Autowired
	CustomerService customerService;
	
	LocalDateTime currentTime = LocalDateTime.parse(LocalDateTime.now().toString());
	String dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
			  .format(currentTime);
	
	
}
