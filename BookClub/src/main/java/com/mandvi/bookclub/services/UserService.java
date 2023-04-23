package com.mandvi.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mandvi.bookclub.models.LoginUser;
import com.mandvi.bookclub.models.User;
import com.mandvi.bookclub.repositories.UserRepository;

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
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "registerError", "passwords must match");
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
//			User newCreatedUser =  userRepo.save(newUser);
//			return newCreatedUser;
			// now it has .getId
		}
	}

	// ======LOGIN=====
	public User login(LoginUser newLoginObject, BindingResult result) {
		// TO-DO: Additional validations!
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "loginError", "email not in DB");
		} else {
			User user = potentialUser.get();
			// BCRYPT check password
			if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				result.rejectValue("password", "loginError", "invalid password");
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

//        return optionalBook.isPresent() ? optionalBook.get() : null;

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
