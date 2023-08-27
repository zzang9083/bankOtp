package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;

import javax.validation.constraints.NotEmpty;

public class OtpActivateStepSecondRqst {

    @NotEmpty(message = "custId 는 필수값입니다")
    private Long custId;    // 고객 아이디

    @NotEmpty(message = "secuCdn 는 필수값입니다")
    private Long secuCdn; // 보안매체 일련번호

    @NotEmpty(message = "usageCd 는 필수값입니다")
    private String usageCd;    // 사용용도
    @NotEmpty(message = "cpn 는 필수값입니다")
    private String cpn;     // 핸드폰번호

    public SecurityMediaCommand.ActivateOtpStepSecond toCommand(String token) {
        return SecurityMediaCommand.ActivateOtpStepSecond.builder()
                .custId(custId)
                .secuCdn(secuCdn)
                .usageCd(usageCd)
                .cpn(cpn)
                .token(token)
                .build();
    }

}
