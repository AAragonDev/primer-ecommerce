package com.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.Product;
import com.ecommerce.services.ProductServices;

@Controller
@RequestMapping("/")
public class HomeUserController {
	
	private final Logger log = LoggerFactory.getLogger(HomeUserController.class);
	
	@Autowired
	private ProductServices productservices;
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("products", productservices.findAll());
		return "user/home";
	}
	
	@GetMapping("producthome/{id}")
	public String productHome(@PathVariable Integer id,Model model) {
		log.info("id enviado como parametro{}", id);
		Product product = new Product();
		product = productservices.get(id).get();
		model.addAttribute("product", product);
		
		return "user/product_home";
	}
	

}
