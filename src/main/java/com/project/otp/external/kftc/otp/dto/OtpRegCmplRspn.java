package com.project.otp.external.kftc.otp.dto;

// 등록완료
public class OtpRegCmplRspn {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    private String rgsnTs;      // 등록일시

    private String secuCdn;     // ic카드일련번호(otp번호)

    private String fssRgcd;     // 금감원등록코드(요청 - sms코드 / 응답 - 등록수행시 처리를 위한 코드)

}
