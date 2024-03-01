package com.tta.controller.rest;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.event.RegistrationCompleteEvent;
import com.tta.model.entity.User;
import com.tta.registration.RegistrationRequst;
import com.tta.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

		private final UserService userService;
		private final ApplicationEventPublisher publisher;
			
		
		@PostMapping
		public String registerUser(RegistrationRequst registrationRequest, final HttpServletRequest request) {
			
			User user=userService.registerUser(registrationRequest);
			
			//public registration event
			this.publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
			
			return "Success! .  check your email  for complete to your registration";
		}


		private String applicationUrl(HttpServletRequest request) {
			return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		} 
}


