package com.mandvi.w3d1manytomany.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mandvi.w3d1manytomany.models.User;
import com.mandvi.w3d1manytomany.services.ProjectService;
import com.mandvi.w3d1manytomany.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	private UserService userServ;
	@Autowired
	private ProjectService projectServ;
	
	@GetMapping("/dashboard")
	public String index(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		User thisUser = userServ.findOne(userId);
		model.addAttribute("thisUser", thisUser);
		return "index.jsp";
	}
	
}
