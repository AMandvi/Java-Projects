package com.mandvi.projectmanager1.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mandvi.projectmanager1.model.Project;

@Repository
public interface ProjectRepos extends CrudRepository<Project, Long> {
	List<Project> findAll();

}
