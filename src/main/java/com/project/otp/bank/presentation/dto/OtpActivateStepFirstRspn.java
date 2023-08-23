package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class OtpActivateStepFirstRspn {

    private long trnCode;         // 거래코드

    private String otpStateCode; // otp상태코드

    private int authErrCnt;      // 인증오류횟수

    public OtpActivateStepFirstRspn(SecurityMediaInfo.ActivateOtpStepFirst securityMediaInfo) {
        this.trnCode = securityMediaInfo.getTrnCode();
        this.otpStateCode = securityMediaInfo.getOtpStateCode();
        this.authErrCnt = securityMediaInfo.getAuthErrCnt();
    }
}
