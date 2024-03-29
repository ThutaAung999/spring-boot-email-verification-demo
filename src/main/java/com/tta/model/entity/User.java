package com.tta.model.entity;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@NaturalId(mutable = true)
	private String email;
	private String password;
	private String role;
	private boolean isEnabled=false;
	
}
