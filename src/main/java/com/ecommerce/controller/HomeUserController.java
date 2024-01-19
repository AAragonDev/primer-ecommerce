package com.ecommerce.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.models.DetailOrder;
import com.ecommerce.models.Order;
import com.ecommerce.models.Product;
import com.ecommerce.services.ProductServices;

@Controller
@RequestMapping("/")
public class HomeUserController {
	
	
	private final Logger log = LoggerFactory.getLogger(HomeUserController.class);
	
	@Autowired
	private ProductServices productservices;
	
	private List<DetailOrder> details = new ArrayList<DetailOrder>();
	
	private Order order = new Order();
	
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
	
	@PostMapping("/addcart")
	public String addCart(@RequestParam Integer id , @RequestParam Integer amount,Model model) {
		DetailOrder detailorder = new DetailOrder();
		Product product = new Product();
		double count = 0;
		
		Optional<Product> optionalProduct = productservices.get(id);
		log.info("Producto añadido: {}",optionalProduct.get());
		log.info("Cantidad: {}",amount);
		
		product = optionalProduct.get();
		detailorder.setAmount(amount);
		detailorder.setPrice(product.getPrice());
		detailorder.setName(product.getName());
		detailorder.setTotal(product.getPrice()*amount);
		detailorder.setProduct(product);
		
		details.add(detailorder);
		
		count = details.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		order.setTotal(count);
		
		model.addAttribute("detailorders", details);
		model.addAttribute("order", order);
		return "redirect:/cart";
		
	}
	
	@GetMapping("/cart")
	public String cart(Model model) {
		model.addAttribute("detailorders", details);
	    model.addAttribute("order", order);
		return "/user/Cart";
	}
	
	@GetMapping("/delete/cart/{id}")
	public String deleteProductCart(@PathVariable Integer id,Model model) {
		
		List<DetailOrder> newOrders = new ArrayList<DetailOrder>();
		
		for (DetailOrder detailOrder: details) {
			if (detailOrder.getProduct().getId()!=id) {
				newOrders.add(detailOrder);
			}
		}
		
		details = newOrders;
		double count=0;
		count = details.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		order.setTotal(count);
		
		model.addAttribute("detailorders", details);
		model.addAttribute("order", order);
		
		return "redirect:/cart";
	}
	
	}
	
	
	
