package com.ecommerce.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.User;
import com.ecommerce.services.IUserServices;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/user")
public class UserController {
	
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserServices userServices;

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
	
	
	
}
