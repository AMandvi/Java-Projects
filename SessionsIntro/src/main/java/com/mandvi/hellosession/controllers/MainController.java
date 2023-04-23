package com.mandvi.hellosession.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		
//		model.addAttribute("name", "waldo");
		session.setAttribute("name", "Waldo");
		return "index.jsp";
	}
	@RequestMapping("/cool")
	public String cool(HttpSession sesh) {
		String someName = (String) sesh.getAttribute("name");
		System.out.println(someName);
		
		return "demo/cool.jsp";
	}
	@RequestMapping("/form")
	public String formPage() {
		return "form.jsp";
	}
	
	@RequestMapping(value="/processForm", method=RequestMethod.POST)
	public String processForm(@RequestParam("name") String name,
			@RequestParam("powerLevel") int powerLevel,
			HttpSession session,
			RedirectAttributes flash) {
//		System.out.println(name + " : " + powerLevel);
		
		//check
		if(name.length() < 5) {
			System.out.println("Hey name is less thean 5!!!!");
			flash.addFlashAttribute("nameErr","Hey name is less than 5!!!!");
			return "redirect:/form";
		}
		session.setAttribute("name", name);
		session.setAttribute("powerLevel", powerLevel);
		return "redirect:/results";	
		
	}
	@RequestMapping("/results")
	public String results() {
		return "results.jsp";
	}

}
