package com.project.otp.bank.presentation.dto;


import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import lombok.Getter;
import javax.validation.constraints.NotEmpty;

@Getter
public class OtpRegRqst {

    @NotEmpty(message = "custName 는 필수값입니다")
    private String custName;    // 고객명

    @NotEmpty(message = "rnn 는 필수값입니다")
    private String rnn;         // 실명번호(사업자번호)

    @NotEmpty(message = "cpn 는 필수값입니다")
    private String cpn;         // 휴대번호

    public SecurityMediaCommand.RegisterOtpRequest toCommand() {
        return SecurityMediaCommand.RegisterOtpRequest.builder()
                .custName(custName)
                .rnn(rnn)
                .cpn(cpn)
                .build();
    }

}
