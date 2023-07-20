package com.project.otp.external.kftc.otp.dto;

public class OtpSttsInqRqst {
    private String prfmNm;      // 전문성명
    private String bswrCqrcgNo; // 업무고유식별번호
    private String cpn;         // 휴대번호
    private String birtYmd;     // 생년월일
    private String rgsnTs;      // 등록일시
    private long sccdErorNbt;   // 보안카드오류횟수
    private long sccdNoErorNbt; // 보안카드번호오류횟수
}
