package com.ecommerce.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import com.ecommerce.services.ProductServices;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductServices productService;
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products/show";
	}
	
	@GetMapping("/create")
	public String create() {
		return "products/create";
	}
	
	
	@PostMapping("/save")
	public String save(Product product , @RequestParam("file") MultipartFile imgform) {
		if (!imgform.isEmpty()) {
			Path imgDirectory = Paths.get("src//main//resources//static/images");
			String absolutePath =imgDirectory.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imgform.getBytes();
				Path fullPath = Paths.get(absolutePath + "//" + imgform.getOriginalFilename());
				Files.write(fullPath, bytesImg);
				product.setImg(imgform.getOriginalFilename());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		LOGGER.info("este es el objeto producto{}",product);
		
		User u = new User(1, "", "", "", "", "", "", "");
		product.setUser(u);
		productService.save(product);
		return "redirect:/products";
	}
	
}
