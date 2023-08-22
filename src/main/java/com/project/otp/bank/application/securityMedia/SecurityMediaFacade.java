package com.project.otp.bank.application.securityMedia;

import com.project.otp.bank.domain.customer.dto.CustomerInfo;
import com.project.otp.bank.domain.customer.service.CustomerService;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import com.project.otp.bank.domain.securityMedia.service.SecurityMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityMediaFacade {
    
    private final CustomerService customerService;
    private final SecurityMediaService securityMediaService;
    

    

    public SecurityMediaInfo.Main registerOtp(SecurityMediaCommand.RegisterSecurityMediaRequest req) { //디지털otp 발급
        // 고객 디지털 otp 생성
        return securityMediaService.issueSecurityMedia(req, SecurityMediaType.DIGITAL_OTP);
    }

    public SecurityMediaInfo.ActivateOtpStepFirst activateOtpStepFirst(SecurityMediaCommand.ActivateOtpStepFirst req) { //인증 1차 활성화
        return securityMediaService.activateOtpStepFirst(req);
    }

}
