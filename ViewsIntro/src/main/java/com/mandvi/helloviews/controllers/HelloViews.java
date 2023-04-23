package com.mandvi.helloviews.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloViews {
	
	@RequestMapping("/")
	public String index(Model model) {
		
		String test= "<h1>hello</h1>";
		
		String name = "john";
		ArrayList<String> names = new ArrayList<String>();  // []
		names.add("john");
		names.add("ben");
		names.add("Ivan");
		names.add("Eduardo");
		
		model.addAttribute("nameKey", name);
		model.addAttribute("x", "jenny");
		model.addAttribute("arrayNames",names);
//		model.addAttribute("test",test);
		return "index.jsp";
	}
	
	@RequestMapping("/other")
	public String other(Model model) {
		model.addAttribute("bob", 44);
		return "other.jsp";
	}
	
	
 
}
