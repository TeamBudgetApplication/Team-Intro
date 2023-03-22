package edu.wccnet.hheck.final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.hheck.final_project.entity.Checkout;
import edu.wccnet.hheck.final_project.service.CheckoutService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	private CheckoutService checkoutService;
	
	@GetMapping("/list")
	public String listCheckouts(Model model) {
		model.addAttribute("checkouts",checkoutService.getCheckouts());
		return "list-checkouts";
	}
	
	@PostMapping("/addCheckout")
	public String addCheckout(Model model) {
		Checkout checkout = new Checkout();
		model.addAttribute("checkout", checkout);
		return "add-checkout";
	}
	
	@PostMapping("/processCheckout")
	public String processCheckout(@ModelAttribute("checkout") Checkout checkout) {
		System.out.println(checkout);
		checkoutService.saveCheckout(checkout);
		return "redirect:/checkout/list";
	}
	
	@RequestMapping("/updateCheckout")
	public String updateCheckout(Model model, @RequestParam("checkoutID") int id) {
		Checkout checkout = checkoutService.getCheckout(id);
		model.addAttribute(checkout);
		return "add-checkout";
	}
	
	@RequestMapping("/deleteCheckout")
	public String deleteCheckout( @RequestParam("checkoutID") int id) {
		Checkout checkout = checkoutService.getCheckout(id);
		checkoutService.deleteCheckout(checkout);
		return "redirect:/checkout/list";
	}

}
