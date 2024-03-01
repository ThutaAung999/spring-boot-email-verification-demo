package com.tta.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tta.exception.UserAlreadyExistsException;
import com.tta.model.entity.User;
import com.tta.registration.RegistrationRequst;
import com.tta.repository.UserRepository;
import com.tta.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private  final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public User registerUser(RegistrationRequst request) {
		
		Optional<User> user=this.findByEmail(request.email());
		if(user.isPresent()) {
			throw new UserAlreadyExistsException("User  with email "+ request.email()+ "  already exists");
		}

		var newUser= new User();
		newUser.setFirstName(request.firstName());
		newUser.setLastName(request.lastName());
		newUser.setEmial(request.email());
		newUser.setPassword(passwordEncoder.encode(request.password()));
		newUser.setRole(request.role());
		
		
		return userRepository.save(newUser);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

}
