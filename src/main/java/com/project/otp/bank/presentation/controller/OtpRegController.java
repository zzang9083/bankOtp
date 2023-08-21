package com.project.otp.bank.presentation.controller;

import com.project.otp.bank.application.securityMedia.SecurityMediaFacade;
import com.project.otp.bank.common.response.CommonResponse;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
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
    public CommonResponse registerOtp(@RequestBody @Valid OtpRegRqst otpRegRqst) {
        SecurityMediaCommand.RegisterSecurityMediaRequest registerOtpRequest = otpRegRqst.toCommand();
        SecurityMediaInfo.Main securityMediaInfo = securityMediaFacade.registerOtp(registerOtpRequest);
        OtpRegRspn otpRegRspn = new OtpRegRspn(securityMediaInfo);
        return CommonResponse.success(otpRegRspn);
    }



}
