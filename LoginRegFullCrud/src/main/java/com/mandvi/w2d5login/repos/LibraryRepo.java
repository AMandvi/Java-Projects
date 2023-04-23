package com.mandvi.w2d5login.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mandvi.w2d5login.models.Library;

public interface LibraryRepo extends CrudRepository<Library, Long> {
	
	List<Library> findAll();
}
