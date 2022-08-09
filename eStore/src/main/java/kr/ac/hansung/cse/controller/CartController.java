package kr.ac.hansung.cse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.User;
import kr.ac.hansung.cse.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String getCart(Model model) {
		
		//현재 로그인한 User의 CartId를 가져온다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = userService.getUserByUsername(username);
		System.out.println("user" + user);
		int cartId = user.getCart().getId();
		model.addAttribute("cartId", cartId);
		
		return "cart";
	}
}
