package com.project.otp.bank.presentation.controller;


import com.project.otp.bank.application.securityMedia.SecurityMediaFacade;
import com.project.otp.bank.common.response.CommonResponse;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import com.project.otp.bank.presentation.dto.OtpActivateStepFirstRqst;
import com.project.otp.bank.presentation.dto.OtpRegRspn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/otp/auth")
public class OtpAuthController {

    private final SecurityMediaFacade securityMediaFacade;

    public OtpAuthController(SecurityMediaFacade securityMediaFacade) {
        this.securityMediaFacade = securityMediaFacade;
    }

    @PostMapping("/s1")
    public CommonResponse activateOtpS1(@RequestBody @Valid OtpActivateStepFirstRqst otpActivateStepFirstRqst) {
        SecurityMediaCommand.ActivateOtpStepFirst stepFirstRequest = otpActivateStepFirstRqst.toCommand();
        securityMediaFacade.activateOtpStepFirst(stepFirstRequest);
        //OtpRegRspn otpRegRspn = new OtpRegRspn(securityMediaInfo);
        //return CommonResponse.success(otpRegRspn);
    }


}
