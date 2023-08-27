package com.project.otp.bank.application.securityMedia;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import com.project.otp.bank.domain.securityMedia.service.SecurityMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityMediaFacade {

    private final SecurityMediaService securityMediaService;
    

    

    public SecurityMediaInfo.Main registerOtp(SecurityMediaCommand.RegisterSecurityMediaRequest req) { //디지털otp 발급
        // 디지털 otp 발행
        return securityMediaService.issueSecurityMedia(req, SecurityMediaType.DIGITAL_OTP);
    }

    public SecurityMediaInfo.ActivateOtpStepFirst activateOtpStepFirst(SecurityMediaCommand.ActivateOtpStepFirst req) { //인증 1차 활성화
        // 인증 1차 활성화
        return securityMediaService.activateOtpStepFirst(req);
    }

    public SecurityMediaInfo.ActivateOtpStepSecond activateOtpStepSecond(SecurityMediaCommand.ActivateOtpStepSecond req) { //인증 2차 활성화
        // 인증 2차 활성화
        return securityMediaService.activateOtpStepSecond(req);
    }

    public SecurityMediaInfo.VrfyVrfcCd vrfyVrfcCd(SecurityMediaCommand.VrfyVrfcCdRqst req) {    // 인증번호 검증
        // 인증번호 검증
        return securityMediaService.vrfyVrfcCdRqst(req);
    }
}
