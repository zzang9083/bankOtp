package com.project.otp.bank.infrastructure.repository;

import com.project.otp.bank.domain.model.otp.SecurityMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityMediaRepository extends JpaRepository<SecurityMedia, Long> {
}
