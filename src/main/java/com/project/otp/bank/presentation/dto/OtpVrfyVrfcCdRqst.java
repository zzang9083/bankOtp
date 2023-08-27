package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class OtpVrfyVrfcCdRqst {

    @NotEmpty(message = "custId 는 필수값입니다")
    private Long custId;    // 고객 아이디

    @NotEmpty(message = "secuCdn 는 필수값입니다")
    private Long secuCdn; // 보안매체 일련번호

    @NotEmpty(message = "usageCd 는 필수값입니다")
    private String usageCd;    // 사용용도
    @NotEmpty(message = "cpn 는 필수값입니다")
    private String cpn;     // 핸드폰번호

    @NotEmpty(message = "trnCode 는 필수값입니다")
    private long trnCode;         // 거래코드

    @NotEmpty(message = "trnCode 는 필수값입니다")
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
