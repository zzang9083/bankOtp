package com.project.otp.bank.presentation.controller;

import com.project.otp.bank.application.service.CustomerService;
import com.project.otp.bank.domain.model.otp.Token;
import com.project.otp.bank.presentation.dto.OtpRegRqst;
import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.presentation.dto.OtpRegRspn;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/otp")
public class OtpRegController {

    private final CustomerService customerService;

    public OtpRegController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public OtpRegRspn regOtp(@RequestBody OtpRegRqst otpRegRqst) {
        Token token = customerService.regiterDigitalOtp(Customer.ofCustomer(otpRegRqst));

        return OtpRegRspn.of(otpRegRqst, token);

    }

//    @DeleteMapping("/terminate")
//    public void terminateOtp(@RequestBody OtpTerminateRqst otpTerminateRqst) {
//        customerService.issueSecurityMedia(Customer.ofCustomer(otpTerminateRqst));
//
//    }


}
