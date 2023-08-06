package com.project.otp.bank.application.service;

import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.domain.model.otp.SecurityMedia;
import com.project.otp.bank.domain.model.otp.SecurityMediaType;
import com.project.otp.bank.domain.model.otp.Token;
import com.project.otp.bank.domain.repository.OtpRepository;
import com.project.otp.bank.infrastructure.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final SecurityMediaService securityMediaService;
    private final CustomerRepository customerRepository;
    private final OtpRepository otpRepository;


    public CustomerService(CustomerRepository customerRepository, SecurityMediaService securityMediaService, OtpRepository otpRepository) {
        this.securityMediaService = securityMediaService;
        this.customerRepository = customerRepository;
        this.otpRepository = otpRepository;

    }

    //디지털otp 발급
    public Token regiterDigitalOtp(Customer customer) {

        Customer findCustomer = customerRepository.findOptionalCustomerByRnn(customer.getRnn())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));

        Token newToken = null;
        if (customer.verifySecurityMedia()) {
            // 고객 디지털 otp 생성
            SecurityMedia newOtp = securityMediaService.makeSecurityMedia(SecurityMediaType.DIGITAL_OTP, findCustomer);
            // 금결원 디지털 otp 생성 요청
            newToken = otpRepository.reqOtpReg(findCustomer, newOtp);
            // 토큰세팅
            newOtp.addToken(newToken);
        }

        return newToken;
    }

    public void terminateDigitalOtp(Customer customer) {
        //검증

        // 금결원 디지털 otp 해지 요청
    }


}