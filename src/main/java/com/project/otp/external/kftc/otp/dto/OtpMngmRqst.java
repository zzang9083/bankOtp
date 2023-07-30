package com.project.otp.external.kftc.otp.dto;

import com.project.otp.external.kftc.otp.comm.domain.OtpCommInfo;

//사고신고, 사고신고 철회, 등록해지, 이용자정보변경, 오류건수 초기화
public class OtpMngmRqst {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    private String rcipTs;      // 접수일시

    private OtpCommInfo OtpCommInfo; // 거래 공통부

    public OtpMngmRqst(String prfmNm, String bswrCqrcgNo, String cpn, String birtYmd, String rcipTs) {
        this.prfmNm = prfmNm;
        this.bswrCqrcgNo = bswrCqrcgNo;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.rcipTs = rcipTs;
    }

    //otp인증검증요청
    public static class OtpCrtcVrfcReq {
    }
}
