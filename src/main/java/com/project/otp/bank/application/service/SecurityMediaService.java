package com.project.otp.bank.application.service;

import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.domain.model.otp.SecurityMedia;
import com.project.otp.bank.domain.model.otp.SecurityMediaType;
import com.project.otp.bank.infrastructure.repository.SecurityMediaRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityMediaService {

    private final SecurityMediaRepository securityMediaRepository;


    public SecurityMediaService(SecurityMediaRepository securityMediaRepository) {
        this.securityMediaRepository = securityMediaRepository;
    }

    public SecurityMedia makeSecurityMedia(SecurityMediaType securityMediaType, Customer customer) {

        SecurityMedia newDigitalOtp = SecurityMedia.issueDigitalOtp(SecurityMediaType.DIGITAL_OTP, customer);
        securityMediaRepository.save(newDigitalOtp);
        return newDigitalOtp;
    }
}
