package com.project.otp.external.kftc.otp.dto;

// 등록요청, 등록승인, 온라인 재등록, 앱비밀번호재등록
public class OtpRegRqst {
    private String prfmNm;      // 전문성명
    private String bswrCqrcgNo; // 업무고유식별번호
    private String cpn;         // 휴대번호
    private String birtYmd;     // 생년월일
    private String rgsnTs;      // 등록일시
    private String rtn;         // 등록번호
    private String iccrSrn;     // ic카드일련번호
    private String fssRgcd;     // 금감원등록코드
}
