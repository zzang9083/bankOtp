package com.project.otp.external.kftc.otp.dto;

//사고신고, 사고신고 철회, 등록해지, 이용자정보변경, 오류건수 초기화
public class OtpMngmRqst {
    private String prfmNm;      // 전문성명
    private String bswrCqrcgNo; // 업무고유식별번호
    private String cpn;         // 휴대번호
    private String birtYmd;     // 생년월일
    private String rcipTs;      // 접수일시

}
