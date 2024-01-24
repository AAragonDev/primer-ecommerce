package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.Order;
import com.ecommerce.models.Product;
import com.ecommerce.models.Usuario;
import com.ecommerce.services.IOrderServices;
import com.ecommerce.services.IProductServices;
import com.ecommerce.services.IUserServices;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IProductServices productservices;
	
	@Autowired
	private IUserServices userServices;
	
	@Autowired
	private IOrderServices orderServices;
	
	@GetMapping("")
	public String home(Model model) {
		List<Product> products= productservices.findAll();
		model.addAttribute("products", products);
		return "admin/home";
	}
	
	@GetMapping("/usuarios")
	public String users(Model model) {
		
		List<Usuario> users = userServices.findAll();
		model.addAttribute("users",users);
		return "admin/users";
	}
	
	@GetMapping("/ordenes")
	public String orders(Model model) {
		
		List<Order> orders = orderServices.findAll();
		model.addAttribute("orders",orders);
		return "admin/orders";
	}
	
	@GetMapping("/detalle/{id}")
	public String detailorders(@PathVariable Integer id, Model model) {
		
		Order order = orderServices.findById(id).get();
		model.addAttribute("details",order.getDetailorder());
		return "admin/detailorder";
	}
	
	
	

}
