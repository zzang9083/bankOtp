package com.project.otp.bank.presentation.controller;


import com.project.otp.bank.application.securityMedia.SecurityMediaFacade;
import com.project.otp.bank.common.response.CommonResponse;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import com.project.otp.bank.presentation.dto.*;
import org.springframework.web.bind.annotation.*;

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
        SecurityMediaInfo.ActivateOtpStepFirst repn = securityMediaFacade.activateOtpStepFirst(stepFirstRequest);
        OtpActivateStepFirstRspn otpActivateStepFirstRspn = new OtpActivateStepFirstRspn(repn);
        return CommonResponse.success(otpActivateStepFirstRspn);
    }

    @PostMapping("/s2")
    public CommonResponse activateOtpS2(@RequestHeader("Accept-Token")String token, @RequestBody @Valid OtpActivateStepSecondRqst otpActivateStepSecondRqst) {
        SecurityMediaCommand.ActivateOtpStepSecond stepSecondRequest = OtpActivateStepSecondRqst.toCommand(token);
        SecurityMediaInfo.ActivateOtpStepSecond repn = securityMediaFacade.activateOtpStepSecond(stepSecondRequest);

        OtpActivateStepSecondRspn otpActivateStepSecondRspn = new OtpActivateStepSecondRspn(repn);
        return CommonResponse.success(otpActivateStepFirstRspn);
    }




}
