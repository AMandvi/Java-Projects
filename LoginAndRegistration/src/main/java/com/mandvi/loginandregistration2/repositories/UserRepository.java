package com.mandvi.loginandregistration2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mandvi.loginandregistration2.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	//to look for email that already exists in DB
	Optional<User> findByEmail(String email);

}
