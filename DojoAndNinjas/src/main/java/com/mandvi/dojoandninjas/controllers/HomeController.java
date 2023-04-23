package com.mandvi.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mandvi.dojoandninjas.models.Dojo;
import com.mandvi.dojoandninjas.models.Ninja;
import com.mandvi.dojoandninjas.services.DojoService;
import com.mandvi.dojoandninjas.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;

	// CREATE PAGE
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "createNinja.jsp";
	}

	// CREATE METHOD - REDIRECT
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,
			RedirectAttributes flash, Model model) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "createNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			flash.addFlashAttribute("success", "cool you made a ninja!!");
			return "redirect:/dojos/"+ninja.getDojo().getId();
		}

	}
	
	@GetMapping("/dojos/new")
	public String dojos(@ModelAttribute("dojo")Dojo dojo, 
		Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "createDojo.jsp";
	}

	// POST METHOD= create dojo
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res, Model model) {
		if (res.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "createDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/"+dojo.getId();

		}

	}
	//show single dojo and its ninjas
		@GetMapping("/dojos/{id}")
		public String getDojo(@PathVariable("id") Long DojoId, Model model) {
			Dojo thisDojo = dojoService.findDojo(DojoId);
			model.addAttribute("thisDojo", thisDojo);
			return "oneDojoWithNinjas.jsp";
		}
	
	

}
