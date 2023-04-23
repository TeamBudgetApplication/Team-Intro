package edu.wccnet.hheck.final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.wccnet.hheck.final_project.entity.Customer;
import edu.wccnet.hheck.final_project.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customers",customerService.getCustomers());
		return "list-customers";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@PostMapping("/processCustomer")
	public String processCustomer(@ModelAttribute("customer") Customer theCustomer) {
		System.out.println(theCustomer);
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(Model model, @RequestParam("customerID") int id) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute(customer);
		return "add-customer";
	}
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer( @RequestParam("customerID") int id) {
		Customer customer = customerService.getCustomer(id);
		customerService.deleteCustomer(customer);
		return "redirect:/customer/list";
	}

}

