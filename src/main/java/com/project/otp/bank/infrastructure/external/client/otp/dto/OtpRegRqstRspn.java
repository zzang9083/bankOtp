package com.project.otp.bank.infrastructure.external.client.otp.dto;

import com.project.otp.bank.domain.securityMedia.model.Token;
import com.project.otp.bank.infrastructure.external.client.otp.comm.OtpCommInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

// 등록응답

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtpRegRqstRspn {

    private String prfmNm;               // 전문성명

    private String bswrCqrcgNo;         // 업무고유식별번호

    private String cpn;                 // 휴대번호

    private LocalDate birtYmd;          // 생년월일

    private LocalDateTime rgsnTs;       // 등록일시

    private Long secuCdn;       // 보안매체 일련번호

    private Long usisNo;      //금결원 이용자 번호

    private String tknNo;             // 토큰번호

    private LocalDateTime tknIsncTs; // 발급시간

    private LocalDateTime tknExpyTs; // 만료시간

    private OtpCommInfo otpCommInfo; // 거래 공통부

    public void checkFnbbRpcdNo() {
        String fnbbRpcdNo = this.otpCommInfo.getFnbbRpcdNo();

    }


    public Token convert() {
        return new Token(usisNo,tknNo,tknIsncTs,tknExpyTs,LocalDateTime.now());
    }
}
