package com.project.otp.bank.infrastructure.external.client.builder.otp.dto;

public class OtpSttsInqRqst {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    private String rgsnTs;      // 등록일시

    private long sccdErorNbt;   // 보안카드오류횟수

    private long sccdNoErorNbt; // 보안카드번호오류횟수

    public OtpSttsInqRqst(String prfmNm, String bswrCqrcgNo, String cpn, String birtYmd
            , String rgsnTs, long sccdErorNbt, long sccdNoErorNbt) {
        this.prfmNm = prfmNm;
        this.bswrCqrcgNo = bswrCqrcgNo;
        this.cpn = cpn;
        this.birtYmd = birtYmd;
        this.rgsnTs = rgsnTs;
        this.sccdErorNbt = sccdErorNbt;
        this.sccdNoErorNbt = sccdNoErorNbt;
    }
}
