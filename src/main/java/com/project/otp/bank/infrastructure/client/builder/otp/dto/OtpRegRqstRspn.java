package com.project.otp.bank.infrastructure.client.builder.otp.dto;

import com.project.otp.bank.domain.error.BusinessException;
import com.project.otp.bank.infrastructure.client.builder.otp.comm.OtpCommInfo;
import com.project.otp.bank.infrastructure.entity.OtpRegEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

// 등록응답

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtpRegRqstRspn {

    private String usisNo;      //금결원 이용자 번호

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

    public OtpRegEntity ofOtpRegEntity() {
        return OtpRegEntity.builder()
                .usisNo(usisNo)
                .prfmNm(prfmNm)
                .bswrCqrcgNo(bswrCqrcgNo)
                .cpn(cpn)
                .birtYmd(birtYmd)
                .rgsnTs(rgsnTs)
                .secuCdn(secuCdn)
                .tknNo(tknNo)
                .tknIsncTs(tknIsncTs)
                .tknExpyTs(tknExpyTs)
                .otpCommInfo(otpCommInfo)
                .build();
    }

    public void checkFnbbRpcdNo() {
        String fnbbRpcdNo = this.otpCommInfo.getFnbbRpcdNo();
        if(!"0000".equals(fnbbRpcdNo)) {
            throw new BusinessException();
        }
    }


}
