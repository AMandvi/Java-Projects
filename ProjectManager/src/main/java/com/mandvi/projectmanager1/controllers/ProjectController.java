package com.mandvi.projectmanager1.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mandvi.projectmanager1.model.Project;
import com.mandvi.projectmanager1.model.User;
import com.mandvi.projectmanager1.services.ProjectService;
import com.mandvi.projectmanager1.services.UserService;


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
		
		List<Project> projectsBelongTo = thisUser.getProjectsBelongTo();
		List<Project> allProjects = projectServ.allProjects();
		List<Project> projectsNotBelonging = new ArrayList<Project>();
		
//		for (int i = 0; i< allProjects.size(); i++) {
//			Project project = allProjects.get(i);
//			if (!project.getUsersThatBelongTo().contains(thisUser)) {
//				projectsNotBelonging.add(project);
//			}
//		}
//		
//		model.addAttribute("projectsNotBelonging", projectsNotBelonging);
//		model.addAttribute("projectsBelongTo", projectsBelongTo)
		
		return "index.jsp";
	}
	
}
