package kr.ac.hansung.cse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController { // controller -> service -> dao

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String getProducts(Model model) {
		
	}
}
