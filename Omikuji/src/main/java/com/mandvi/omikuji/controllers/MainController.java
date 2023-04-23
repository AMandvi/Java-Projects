package com.mandvi.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/omikuji")
	public String formPage() {
		return "form.jsp";
	}
	
	@RequestMapping(value="/processForm", method=RequestMethod.POST)
	public String processForm(@RequestParam("randomNumber") int randomNumber,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("thing") String thing,
			@RequestParam("niceTalk") String niceTalk,
			HttpSession session) {
		
		session.setAttribute("randomNumber", randomNumber);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("niceTalk", niceTalk);
		return "redirect:/omikuji/show";		
	}
	
	@RequestMapping("/omikuji/show")
	public String results() {
		return "results.jsp";
	}

}
