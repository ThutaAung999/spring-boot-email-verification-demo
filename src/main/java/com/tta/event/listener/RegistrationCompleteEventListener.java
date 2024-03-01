package com.tta.event.listener;

import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.tta.event.RegistrationCompleteEvent;
import com.tta.model.entity.User;
import com.tta.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{

	private final UserService userService;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// 1. Get the newly created registered user
			User user=event.getUser();
		//2.Creation a verification token for the user
			String verificationToken = UUID.randomUUID().toString();
		
		//3.Save the verification token for the user to the DB
			userService.saveUserVerificationToken(user,verificationToken);
			
			
		//4.Build the  verification url to be sent to the user 
			String url=event.getApplicationUrl()+"/register/verifyEmail?token="+verificationToken;
				
		//5.Send the  email	
		
			log.info("Click the link to verify  your registration  : {}", url);
	}

}
