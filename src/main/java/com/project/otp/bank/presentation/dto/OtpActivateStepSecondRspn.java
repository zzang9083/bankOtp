package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OtpActivateStepSecondRspn {

    private String custName;    // 고객명

    private String rnn; // 실명번호(사업자번호)

    private String cpn;     // 핸드폰번호

    private LocalDate birtYmd; // 생년월일

    private Long secuCdn; // 보안매체 일련번호

    private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

    private String token; // 토큰값

    private Long vrfcCd;    // 인증코드

    private String trnContent; // 거래내역

    public OtpActivateStepSecondRspn(SecurityMediaInfo.ActivateOtpStepSecond stepSecond) {
        this.custName = stepSecond.getCustName();
        this.rnn = stepSecond.getRnn();
        this.cpn = stepSecond.getCpn();
        this.birtYmd = stepSecond.getBirtYmd();
        this.secuCdn = stepSecond.getSecuCdn();
        this.usageCd = stepSecond.getUsageCd();
        this.token = stepSecond.getToken();
        this.vrfcCd = stepSecond.getVrfcCd();
        this.trnContent = stepSecond.getTrnContent();
    }
}
