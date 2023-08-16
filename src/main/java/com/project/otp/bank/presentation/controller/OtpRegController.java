package com.project.otp.bank.presentation.controller;

import com.project.otp.bank.application.securityMedia.SecurityMediaFacade;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.presentation.dto.OtpRegRqst;
import com.project.otp.bank.presentation.dto.OtpRegRspn;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bank/otp")
public class OtpRegController {

    private final SecurityMediaFacade securityMediaFacade;

    public OtpRegController(SecurityMediaFacade securityMediaFacade) {
        this.securityMediaFacade = securityMediaFacade;
    }

    @PostMapping("/register")
    public OtpRegRspn registerOtp(@RequestBody @Valid OtpRegRqst otpRegRqst) {
        SecurityMediaCommand.RegisterSecurityMediaRequest registerOtpRequest = otpRegRqst.toCommand();
        Token token = securityMediaFacade.registerOtp(registerOtpRequest);

        return OtpRegRspn.of(otpRegRqst, token);

    }

//    @DeleteMapping("/terminate")
//    public void terminateOtp(@RequestBody OtpTerminateRqst otpTerminateRqst) {
//        customerService.issueSecurityMedia(Customer.ofCustomer(otpTerminateRqst));
//
//    }


}
