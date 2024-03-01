package com.tta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tta.model.entity.VerificationToken;

public interface VerificationTokenRepositry  extends  JpaRepository<VerificationToken, Long>{

}
