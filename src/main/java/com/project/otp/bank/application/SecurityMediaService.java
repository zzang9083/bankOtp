package com.project.otp.bank.application;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.domain.otp.SecurityMedia;
import com.project.otp.bank.domain.otp.SecurityMediaType;
import com.project.otp.bank.repository.SecurityMediaRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityMediaService {

    private final SecurityMediaRepository securityMediaRepository;

    private final SecurityMediaService securityMediaService;

    public SecurityMediaService(SecurityMediaRepository securityMediaRepository, SecurityMediaService securityMediaService) {
        this.securityMediaRepository = securityMediaRepository;
        this.securityMediaService = securityMediaService;
    }

    public SecurityMedia makeSecurityMedia(SecurityMediaType securityMediaType, Customer customer) {

        SecurityMedia newDigitalOtp = SecurityMedia.makeDigitalOtp(SecurityMediaType.DIGITAL_OTP, customer);
        securityMediaRepository.save(newDigitalOtp);
        return newDigitalOtp;
    }
}
