package com.mandvi.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandvi.dojoandninjas.models.Dojo;
import com.mandvi.dojoandninjas.repositories.DojoRepository;


@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository;
	
	//-------FULL CRUD------
	// READ ALL
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
    // CREATE
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    // READ ONE
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
//    //UPDATE
//    public Dojo updateDojo(Dojo dojo) {
//    	Dojo updateDojo = dojoRepository.save(dojo);
//    	return updateDojo;
//    }
//    
//    //DELETE //deleteById returns void thats why void method
//    public void deleteDojo(Long id) {
//    	dojoRepository.deleteById(id);
//    }
}
