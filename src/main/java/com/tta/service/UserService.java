package com.tta.service;

import java.util.List;
import java.util.Optional;

import com.tta.model.entity.User;
import com.tta.registration.RegistrationRequst;

public interface UserService {

	List<User> getUsers();
	User registerUser(RegistrationRequst request);
	Optional<User> findByEmail(String email);
}
