package com.mandvi.w2d5login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandvi.w2d5login.models.Library;
import com.mandvi.w2d5login.repos.LibraryRepo;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepo libraryRepo;

	// ======FULL CRUD ======   
	    
	    // READ ALL
	    public List<Library> allLibraries() {
	        return libraryRepo.findAll();
	    }
	    // CREATE
	    public Library createLib(Library l) {
	        return libraryRepo.save(l);
	    }
	    // READ ONE
	    public Library findLib(Long id) {
	        Optional<Library> optionalBook = libraryRepo.findById(id);
	        
//	        return optionalBook.isPresent() ? optionalBook.get() : null;
	        
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    
	    //UPDATE
	    public Library updateLib(Library l) {
	    	Library updateLib = libraryRepo.save(l);
	    	return updateLib;
	    }
	    
	    //DELETE //deleteById returns void thats why void method
	    public void deleteLib(Long id) {
	    	libraryRepo.deleteById(id);
	    }
	

}
