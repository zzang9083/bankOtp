package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class OtpActivateStepFirstRqst {

    @NotNull(message = "custId 는 필수값입니다")
    private Long custId;    // 고객 아이디

    @NotEmpty(message = "usageCd 는 필수값입니다")
    private String usageCd;    // 사용용도

    @NotEmpty(message = "trnContent 는 필수값입니다")
    private String trnContent;    // 거래 내용

    public SecurityMediaCommand.ActivateOtpStepFirst toCommand() {
        return SecurityMediaCommand.ActivateOtpStepFirst.builder()
                .custId(custId)
                .usageCd(usageCd)
                .trnContent(trnContent)
                .build();
    }
}
