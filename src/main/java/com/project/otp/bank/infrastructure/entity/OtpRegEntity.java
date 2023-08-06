package com.project.otp.bank.infrastructure.entity;

import com.project.otp.bank.domain.model.otp.Token;
import com.project.otp.bank.infrastructure.client.builder.otp.comm.OtpCommInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtpRegEntity {

    private String usisNo;      //

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    private String rgsnTs;      // 등록일시

    private Long secuCdn;       // 보안매체 일련번호
    private String tknNo;       // 토큰번호 400

    private LocalDateTime tknIsncTs; // 발급시간

    private LocalDateTime tknExpyTs; // 만료시간

    private OtpCommInfo otpCommInfo; // 거래 공통부

    @Builder
    public OtpRegEntity(String usisNo, String prfmNm, String bswrCqrcgNo, String cpn, String birtYmd, String rgsnTs, Long secuCdn, String tknNo, LocalDateTime tknIsncTs, LocalDateTime tknExpyTs, OtpCommInfo otpCommInfo) {
        this.usisNo = usisNo;
        this.prfmNm = prfmNm;
        this.bswrCqrcgNo = bswrCqrcgNo;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.rgsnTs = rgsnTs;
        this.secuCdn = secuCdn;
        this.tknNo = tknNo;
        this.tknIsncTs = tknIsncTs;
        this.tknExpyTs = tknExpyTs;
        this.otpCommInfo = otpCommInfo;
    }

    public Token convert() {
        return new Token(usisNo,tknNo,tknIsncTs,tknExpyTs,LocalDateTime.now());
    }
}
