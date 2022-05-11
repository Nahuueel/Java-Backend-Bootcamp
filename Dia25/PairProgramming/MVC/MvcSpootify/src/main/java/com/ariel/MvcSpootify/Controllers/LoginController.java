package com.ariel.MvcSpootify.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ariel.MvcSpootify.Model.Users;

@Controller
public class LoginController {
	
	@Autowired
	RestTemplate r;
	
	@GetMapping({"/", "/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}

	@PostMapping("/register")
	public String register(RedirectAttributes redirect,@Validated @ModelAttribute Users registedUser, BindingResult result ){
		if(result.hasErrors()) return "/";
		r.postForEntity("http://localhost:8000/api/users", registedUser, String.class);
		return "/";
	}

}
