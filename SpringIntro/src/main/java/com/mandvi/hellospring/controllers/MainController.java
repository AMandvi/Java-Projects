package com.mandvi.hellospring.controllers;
import org.springframework.web.bind.annotation.PathVariable;
//2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

//@RequestMapping("/api")

public class MainController {
	// 1. Annotation
	@RequestMapping("/")
	
	// 3. Method that maps to the request route above
	public String index() {
		return "hello ninjas!";
	}
	
	@RequestMapping("/cool")
	public String cool() {
		System.out.println("this works!!!");
		return "this is cool";
	}
	
	//====QUERY PARAMETERS====
	//http://localhost:8080/search?q=texthere
	@RequestMapping("/search")
	public String search(@RequestParam(value = "q") String someSearchVar) {
		return "you searched for " + someSearchVar;
	}
	
	//====PATH VARIABLES====
	//http://localhost:8080/find/{var1}
	@RequestMapping("/find/{name}/{num}/{thing}")
	public String find(@PathVariable("name")String name,
			@PathVariable("num") int num,
			@PathVariable("thing") String thing) {
		if (num > 10) {
			return name + " has too many " + thing;
		}
		return "you found  " + name + " and they have " + num + " " + thing;
	}

}
