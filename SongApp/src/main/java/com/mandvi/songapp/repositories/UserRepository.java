package com.mandvi.songapp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mandvi.songapp.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	//to look for email that already exists in DB
//	Optional<User> findByEmail(String email);

	Optional<User> findByEmail(String email);

}
