package com.project.otp.bank.infrastructure.securityMedia;


import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityMediaRepository extends JpaRepository<SecurityMedia, Long> {
}
