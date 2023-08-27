package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OtpVrfyVrfcCdRspn {

    private String custName;    // 고객명

    private String rnn; // 실명번호(사업자번호)

    private String cpn;     // 핸드폰번호

    private LocalDate birtYmd; // 생년월일

    private Long secuCdn; // 보안매체 일련번호

    private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

    private Long vrfcCd;    // 인증코드

    private long trnCode; // 거래코드

    private LocalDateTime trnReqAt; // 거래요청시간



    public OtpVrfyVrfcCdRspn(SecurityMediaInfo.VrfyVrfcCd vrfyVrfcCd) {
        this.custName = vrfyVrfcCd.getCustName();
        this.rnn = vrfyVrfcCd.getRnn();
        this.cpn = vrfyVrfcCd.getCpn();
        this.birtYmd = vrfyVrfcCd.getBirtYmd();
        this.secuCdn = vrfyVrfcCd.getSecuCdn();
        this.usageCd = vrfyVrfcCd.getUsageCd();
        this.trnCode = vrfyVrfcCd.getTrnCode();
        this.vrfcCd = vrfyVrfcCd.getVrfcCd();
        this.trnReqAt = vrfyVrfcCd.getTrnReqAt();
    }
}
