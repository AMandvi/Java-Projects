package com.mandvi.w2d5login.controllers;

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

import com.mandvi.w2d5login.models.Library;
import com.mandvi.w2d5login.services.LibraryService;

@Controller
public class LibraryController {
	
	@Autowired
	private LibraryService libServ;
	
	@GetMapping("/libraries")
	public String libraries(@ModelAttribute("library")Library library, 
		Model model) {
		List<Library> allDaLibs = libServ.allLibraries();
		model.addAttribute("allLibraries", allDaLibs);
		//going to display allLibraries on libs.jsp
		//not recommended like this
//		model.addAttribute("allLibs", libServ.allLibraries());
		return "/libraries/libs.jsp";
	}
	
	//POST METHOD= create library
	@PostMapping("/libraries")
	public String createLib(@Valid @ModelAttribute("library") Library library,
			BindingResult res, Model model) {
		if(res.hasErrors()) {
			List<Library> allDaLibs = libServ.allLibraries();
			model.addAttribute("allLibraries", allDaLibs);
			return "/libraries/libs.jsp";
		}else {
			libServ.createLib(library);
			return "redirect:/libraries";
		
		}
		
	}
	
	//show single library and its books
	@GetMapping("/library/{id}")
	public String getLibrary(@PathVariable("id") Long libId, Model model) {
		Library thislib = libServ.findLib(libId);
		model.addAttribute("thislib", thislib);
		return "/libraries/oneLibrary.jsp";
	}
	
	
	
	
	
	
	
}
