package com.project.otp.bank.infrastructure.client.builder.otp.dto;

import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.domain.model.otp.SecurityMedia;
import com.project.otp.bank.domain.model.external.ExternalCommConst;
import com.project.otp.bank.infrastructure.client.builder.otp.comm.OtpCommInfo;
import com.project.otp.bank.infrastructure.client.builder.otp.comm.OtpConst;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 등록요청
@Getter
public class OtpRegRqstRqst {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private Long secuCdn;       // 보안매체 일련번호

    private String cpn;         // 휴대번호

    private LocalDate birtYmd;     // 생년월일

    private LocalDateTime rgsnTs;      // 등록일시

    private OtpCommInfo OtpCommInfo; // 거래 공통부

    public OtpRegRqstRqst(Customer customer, SecurityMedia newOtp) {
        this.prfmNm         = customer.getCustName();
        this.bswrCqrcgNo    = customer.getRnn();
        this.secuCdn        = newOtp.getSecuCdn();
        this.cpn            = customer.getCpn();
        this.birtYmd        = customer.getBirtYmd();
        this.rgsnTs         = LocalDateTime.now();
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



    public static OtpRegRqstRqst ofOtpRegRqstRqst(Customer customer, SecurityMedia newOtp) {
        return new OtpRegRqstRqst(customer, newOtp);
    }



}
