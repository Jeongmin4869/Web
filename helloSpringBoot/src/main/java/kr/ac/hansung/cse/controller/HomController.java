package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomController {
	
	// @GetMapping is a composed annotation thia acts as a short cut for
	// @RequestMapping(value = "/", method = RequestMethod.GET);
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mseeage", "hello world");
		return "index";
	}
	
}
