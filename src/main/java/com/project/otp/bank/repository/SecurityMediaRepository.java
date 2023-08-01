package com.project.otp.bank.repository;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.domain.otp.SecurityMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityMediaRepository extends JpaRepository<SecurityMedia, Long> {
}
