package com.project.otp.bank.infrastructure.client.builder.otp.dto;

// 등록 해지 응답
public class OtpTerminationRspn {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    //private String rgsnTs;      // 접수일시

    private String secuCdn;     // ic카드일련번호(otp번호)

}
