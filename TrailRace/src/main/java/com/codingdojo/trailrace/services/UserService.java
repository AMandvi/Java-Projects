package com.codingdojo.trailrace.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.trailrace.models.LoginUser;
import com.codingdojo.trailrace.models.User;
import com.codingdojo.trailrace.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// ====REGISTER======
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "registerError", "this email is taken");
		}
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "registerError", "passwords must match");
		}
		// returns the errors back
		if (result.hasErrors()) {
			return null;
		} else {
			// hash the passwords
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			// SAVE USER TO DB!!
			return userRepo.save(newUser);

		}
	}

	// ======LOGIN=====
	public User login(@Valid LoginUser newUser, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getLoginEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("loginEmail", "loginError", "email not in DB");
		} else {
			User user = potentialUser.get();
			// BCRYPT check password
			if (!BCrypt.checkpw(newUser.getLoginPassword(), user.getPassword())) {
				result.rejectValue("loginPassword", "loginError", "invalid password");
			}
			if (result.hasErrors()) {
				return null;
			} else {
				return user;
			}
		}
		return null;
	}

	// READ ONE
	public User findOne(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	// READ ALL
	public List<User> allDaUsers() {
		return userRepo.findAll();
	}

	

}
