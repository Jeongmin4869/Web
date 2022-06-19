package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String getProducts(Model model) { // controller -> model -> view
		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "productInventory";
		
	}
	
	@RequestMapping("/productInventory/addProduct")
	public String addProduct(Model model) {
		
		Product product = new Product();
		product.setCategory("컴퓨터"); // default 세팅
		
		model.addAttribute("product", product);
		
		
		return "addProduct";
	}
	
}
