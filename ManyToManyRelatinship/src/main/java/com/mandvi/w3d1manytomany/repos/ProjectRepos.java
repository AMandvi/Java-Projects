package com.mandvi.w3d1manytomany.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mandvi.w3d1manytomany.models.Project;
@Repository
public interface ProjectRepos extends CrudRepository<Project, Long> {
	List<Project> findAll();

}
