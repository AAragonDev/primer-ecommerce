package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.Order;
import com.ecommerce.models.User;
import com.ecommerce.services.IOrderServices;
import com.ecommerce.services.IUserServices;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequestMapping("/user")
public class UserController {
	
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserServices userServices;
	
	@Autowired
	private IOrderServices orderServices;

	@GetMapping("/register")
	public String Register() {
		return "/user/register";
	}
	
	@PostMapping("/save")
	public String save(User user) {
		log.info("Usuario registro: {}", user);
		user.setType("USER");
		userServices.save(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	@PostMapping("/access")
	public String access(User user,HttpSession session) {
		log.info("accesos: {}",user);
		
		Optional<User> userback = userServices.findByEmail(user.getEmail());
		
		if(userback.isPresent()) {
			session.setAttribute("iduser", userback.get().getId());
			if(userback.get().getType().equals("ADMIN")) {
				return "redirect:/admin";
			}else {
				return "redirect:/";
			}
		}else {
			log.info("Usuario no existe");
		}
		return "redirect:/";
	}
	
	@GetMapping("/compras")
	public String getShopping(HttpSession session, Model model) {
		model.addAttribute("sesion", session.getAttribute("iduser"));
		
		User user = userServices.findById(Integer.parseInt(session.getAttribute("iduser").toString())).get();
		List<Order> orders = orderServices.findByUser(user);
		
		model.addAttribute("orders", orders);
		return "user/shopping";
	}
	
	@GetMapping("/detalle/{id}")
	public String detailShopping(@PathVariable Integer id,HttpSession session,Model model) {
		
		Order order = orderServices.findById(id).get();
		
		model.addAttribute("details",order.getDetailorder());
		model.addAttribute(session.getAttribute("iduser"));
		
		return "user/detallecompra";
	}
	
	@GetMapping("/cerrar")
	public String cerrarsesion(HttpSession session) {
		session.removeAttribute("iduser");
		return "redirect:/";
	}
	
	
	
	
}
