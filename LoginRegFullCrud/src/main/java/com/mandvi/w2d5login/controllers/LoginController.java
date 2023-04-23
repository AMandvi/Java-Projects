package com.mandvi.w2d5login.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mandvi.w2d5login.models.LoginUser;
import com.mandvi.w2d5login.models.User;
import com.mandvi.w2d5login.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userServ;

	@GetMapping("/home")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		//1. execute the Service method First
		userServ.register(newUser, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		else {
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/success";
		}

		
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}else {
			session.setAttribute("user_id", user.getId());
			return "redirect:/success";
		}
		
	}
	
	@GetMapping("/success")
	public String success(HttpSession s, Model model) {
		Long userId = (Long) s.getAttribute("user_id");
		//check if this in session
		if (userId == null) {
			return "redirect:/home";
		}else {
		User thisUser = userServ.findOne(userId);
		model.addAttribute("thisUser", thisUser);
		return "success.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession s) {
		//this will clear everything in session
		s.invalidate();
		return "redirect:/home";
	}

}
