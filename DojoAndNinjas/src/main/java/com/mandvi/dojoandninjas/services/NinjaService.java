package com.mandvi.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandvi.dojoandninjas.models.Ninja;
import com.mandvi.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepository;
	
	//-------FULL CRUD------
	
	//READ ALL
	public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
	
	// CREATE
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    
    // READ ONE
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
//    //UPDATE
//    public Ninja updateNinja(Ninja ninja) {
//    	Ninja updateNinja = ninjaRepository.save(ninja);
//    	return updateNinja;
//    }
//    
//    //DELETE //deleteById returns void thats why void method
//    public void deleteNinja(Long id) {
//    	ninjaRepository.deleteById(id);
//    }
   

}
