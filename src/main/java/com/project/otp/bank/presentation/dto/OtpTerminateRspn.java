package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@Getter
public class OtpTerminateRspn {
    private Long custId;    // 고객 아이디
    private Long secuCdn; // 보안매체 일련번호

    private String usageCd;    // 사용용도

    private String cpn;     // 핸드폰번호

    private long trnCode;         // 거래코드

    private Long vrfcCd;    // 인증코드

    private LocalDateTime trnReqAt;     // 거래요청일시



    public SecurityMediaCommand.VrfyVrfcCdRqst toCommand(String token) {
        return SecurityMediaCommand.VrfyVrfcCdRqst.builder()
                .custId(custId)
                .secuCdn(secuCdn)
                .usageCd(usageCd)
                .cpn(cpn)
                .token(token)
                .trnCode(trnCode)
                .vrfcCd(vrfcCd)
                .trnReqAt(LocalDateTime.now())
                .build();
    }
}
