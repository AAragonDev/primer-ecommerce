package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.Product;
import com.ecommerce.services.IProductServices;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IProductServices productservices;
	
	@GetMapping("")
	public String home(Model model) {
		List<Product> products= productservices.findAll();
		model.addAttribute("products", products);
		return "admin/home";
	}
	
	

}
