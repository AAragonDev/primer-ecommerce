package com.ecommerce.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import com.ecommerce.services.IProductServices;
import com.ecommerce.services.IUserServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductServices productService;
	
	@Autowired
	private IUserServices userServices;
	
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
	public String save(Product product , @RequestParam("file") MultipartFile imgform,HttpSession session) {
		if (!imgform.isEmpty()) {
			Path imgDirectory = Paths.get("images//");
			String absolutePath =imgDirectory.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imgform.getBytes();
				Path fullPath = Paths.get(absolutePath + "//" + imgform.getOriginalFilename());
				Files.write(fullPath, bytesImg);
				product.setImg(imgform.getOriginalFilename());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			product.setImg("default.jpg");
		}
		
		LOGGER.info("este es el objeto producto{}",product);
		
		User u = userServices.findById(Integer.parseInt(session.getAttribute("iduser").toString())).get();
		product.setUser(u);
		productService.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id,Model model) {
		Product product = new Product();
		Optional<Product> optionalProduct = productService.get(id);
		product = optionalProduct.get();
		
		LOGGER.info("producto buscado: {}",product);
		model.addAttribute("product", product);
		return "products/edit";
		
	}
	
	@PostMapping("/update")
	public String update(Product product,@RequestParam("file") MultipartFile imgform) {
		Product p = new Product();
		p = productService.get(product.getId()).get();
		
		if (!imgform.isEmpty()) {
			
			
			
			if (!p.getImg().equals("default.jpg")) {
				String path = "images//";
				File file = new File (path+p.getImg());
				file.delete();
			}
			
			Path imgDirectory = Paths.get("src//main//resources//static//images//");
			String absolutePath =imgDirectory.toFile().getAbsolutePath();
			try {
				byte[] bytesImg = imgform.getBytes();
				Path fullPath = Paths.get(absolutePath + "//" + imgform.getOriginalFilename());
				Files.write(fullPath, bytesImg);
				product.setImg(imgform.getOriginalFilename());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			product.setImg(p.getImg());
			
			
		}
		product.setUser(p.getUser());
		productService.update(product);
		return "redirect:/products";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Product p = new Product();
		p = productService.get(id).get();
		if (!p.getImg().equals("default.jpg")) {
			LOGGER.info("entro");
			String path = "images//";
			File file = new File (path+p.getImg());
			file.delete();
		}
		productService.delete(id);
		return "redirect:/products";
	}
	
}
