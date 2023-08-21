package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;

import javax.validation.constraints.NotEmpty;

public class OtpActivateStepFirstRqst {

    @NotEmpty(message = "custId 는 필수값입니다")
    private Long custId;    // 고객 아이디

    @NotEmpty(message = "trnContent 는 필수값입니다")
    private String trnContent;    // 거래 내용

    public SecurityMediaCommand.ActivateOtpStepFirst toCommand() {
        return SecurityMediaCommand.ActivateOtpStepFirst.builder()
                .custId(custId)
                .trnContent(trnContent)
                .build();
    }
}
