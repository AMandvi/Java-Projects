package com.mandvi.w2d3fullcrud1.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mandvi.w2d3fullcrud1.models.Library;

public interface LibraryRepo extends CrudRepository<Library, Long> {
	
	List<Library> findAll();
}
