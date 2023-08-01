package com.project.otp.external.kftc.otp.dto;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.external.comm.ExternalCommConst;
import com.project.otp.external.kftc.otp.dto.comm.OtpCommInfo;
import com.project.otp.external.kftc.otp.dto.comm.OtpConst;

import java.time.LocalDateTime;

// 등록요청
public class OtpRegRqstRqst {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private Long secuCdn;       // 보안매체 일련번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    private String rgsnTs;      // 등록일시

    private OtpCommInfo OtpCommInfo; // 거래 공통부

    public OtpRegRqstRqst(Customer customer) {
        this.prfmNm         = customer.getCustName();
        this.bswrCqrcgNo    = customer.getRnn();
        this.secuCdn        = customer.get
        this.cpn            = customer.getCpn();
        this.birtYmd        = customer.getBirth();
        this.rgsnTs         = LocalDateTime.now().toString();
        this.OtpCommInfo    = setOtpCommInfo();

    }

    public OtpCommInfo setOtpCommInfo() {
        return OtpCommInfo.builder()
                .extTrnBswrDcd(OtpConst.EXT_TRN_OMSM)
                .tlgrIttcd(OtpConst.OTP_TLGR_ITTCD_0100)
                .extTrnDcd(OtpConst.OTP_TRN_DSNC_NO_100104)
                .hndlIcd(ExternalCommConst.BN_CD_003)
                .fnbbRpcdNo(null)
                .trnTlgrSrn("1")
                .tlsdHms(LocalDateTime.now().toString()).build();
    }



    public static OtpRegRqstRqst ofOtpRegRqstRqst(Customer customer) {
        return new OtpRegRqstRqst(customer);
    }



}
