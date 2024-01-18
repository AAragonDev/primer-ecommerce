package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.services.ProductServices;

@Controller
@RequestMapping("/")
public class HomeUserController {
	
	@Autowired
	private ProductServices productservices;
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("products", productservices.findAll());
		return "user/home";
	}
	

}
