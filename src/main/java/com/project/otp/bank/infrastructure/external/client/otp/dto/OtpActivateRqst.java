package com.project.otp.bank.infrastructure.external.client.otp.dto;

import com.project.otp.bank.domain.external.model.ExternalCommConst;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaApiCommand;
import com.project.otp.bank.infrastructure.external.client.otp.comm.OtpCommInfo;
import com.project.otp.bank.infrastructure.external.client.otp.comm.OtpConst;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 활성화요청
public class OtpActivateRqst {
    @Getter
    public static class StepFirst { // 1차 활성화

        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String trnContent; // 거래내역

        private OtpCommInfo otpCommInfo; // 거래 공통부

        public StepFirst(SecurityMediaApiCommand.ActivateOtpStepFirstApiCommand externalReq) {
            this.custName = externalReq.getCustName();
            this.rnn = externalReq.getRnn();
            this.cpn = externalReq.getCpn();
            this.birtYmd = externalReq.getBirtYmd();
            this.secuCdn = externalReq.getSecuCdn();
            this.usageCd = externalReq.getUsageCd();
            this.trnContent = externalReq.getTrnContent();
            this.otpCommInfo = setOtpCommInfo();
        }

        public OtpCommInfo setOtpCommInfo() {
            return OtpCommInfo.builder()
                    .extTrnBswrDcd(OtpConst.EXT_TRN_OMSM)
                    .tlgrIttcd(OtpConst.OTP_TLGR_ITTCD_0200)
                    .extTrnDcd(OtpConst.OTP_TRN_DSNC_NO_200101)
                    .hndlIcd(ExternalCommConst.BN_CD_003)
                    .fnbbRpcdNo(null)
                    .trnTlgrSrn("1")
                    .tlsdHms(LocalDateTime.now().toString()).build();
        }

        public static StepFirst ofStepFirst(SecurityMediaApiCommand.ActivateOtpStepFirstApiCommand externalReq) {
            return new StepFirst(externalReq);
        }

    }
}
