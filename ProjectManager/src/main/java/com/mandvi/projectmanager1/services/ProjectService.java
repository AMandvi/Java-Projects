package com.mandvi.projectmanager1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandvi.projectmanager1.model.Project;
import com.mandvi.projectmanager1.repos.ProjectRepos;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepos projectRepo;

	// ======FULL CRUD ======   
	    
	    // READ ALL
	    public List<Project> allProjects() {
	        return projectRepo.findAll();
	    }
	    // CREATE
	    public Project createProject(Project p) {
//	    	b.setAuthor("bob");
	        return projectRepo.save(p);
	    }
	    // READ ONE
	    public Project findProject(Long id) {
	        Optional<Project> optionalProject = projectRepo.findById(id);
	        
//	        return optionalBook.isPresent() ? optionalBook.get() : null;
	        
	        if(optionalProject.isPresent()) {
	            return optionalProject.get();
	        } else {
	            return null;
	        }
	    }
	    
	    //UPDATE
	    public Project updateProject(Project p) {
	    	Project updateProject = projectRepo.save(p);
	    	return updateProject;
	    }
	    
	    //DELETE //deleteById returns void thats why void method
	    public void deleteProject(Long id) {
	    	projectRepo.deleteById(id);
	    }
}
