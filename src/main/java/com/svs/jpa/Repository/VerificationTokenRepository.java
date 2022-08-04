package com.svs.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.svs.jpa.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

}
