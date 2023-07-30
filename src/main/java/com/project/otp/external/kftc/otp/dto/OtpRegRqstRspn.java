package com.project.otp.external.kftc.otp.dto;

import com.project.otp.external.kftc.otp.comm.domain.OtpCommInfo;

// 등록요청
public class OtpRegRqstRspn {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    private String rgsnTs;      // 등록일시

    private String fssRgcd;     // 금감원등록코드

    private OtpCommInfo OtpCommInfo; // 거래 공통부

}
