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

    public static class StepSecond { // 2차 활성화
        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String token; // 토큰값
        private OtpCommInfo otpCommInfo; // 거래 공통부

        public StepSecond(SecurityMediaApiCommand.ActivateOtpStepSecondApiCommand externalReq) {
            this.custName = externalReq.getCustName();
            this.rnn = externalReq.getRnn();
            this.cpn = externalReq.getCpn();
            this.birtYmd = externalReq.getBirtYmd();
            this.secuCdn = externalReq.getSecuCdn();
            this.usageCd = externalReq.getUsageCd();
            this.token = externalReq.getToken();
            this.otpCommInfo = setOtpCommInfo();
        }

        public OtpCommInfo setOtpCommInfo() {
            return OtpCommInfo.builder()
                    .extTrnBswrDcd(OtpConst.EXT_TRN_OMSM)
                    .tlgrIttcd(OtpConst.OTP_TLGR_ITTCD_0200)
                    .extTrnDcd(OtpConst.OTP_TRN_DSNC_NO_200111)
                    .hndlIcd(ExternalCommConst.BN_CD_003)
                    .fnbbRpcdNo(null)
                    .trnTlgrSrn("1")
                    .tlsdHms(LocalDateTime.now().toString()).build();
        }

        public static StepSecond ofStepSecond(SecurityMediaApiCommand.ActivateOtpStepSecondApiCommand externalReq) {
            return new StepSecond(externalReq);
        }
    }

    public static class VrfyVrfcCd { // 인증번호 검증
        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String token; // 토큰값

        private long trnCode;    // 거래코드

        private Long vrfcCd;    // 인증코드
        private LocalDateTime trnReqAt;     // 거래요청일시
        private OtpCommInfo otpCommInfo; // 거래 공통부

        public VrfyVrfcCd(SecurityMediaApiCommand.VrfyVrfcCdApiCommand externalReq) {
            this.custName = externalReq.getCustName();
            this.rnn = externalReq.getRnn();
            this.cpn = externalReq.getCpn();
            this.birtYmd = externalReq.getBirtYmd();
            this.secuCdn = externalReq.getSecuCdn();
            this.usageCd = externalReq.getUsageCd();
            this.token = externalReq.getToken();
            this.vrfcCd = externalReq.getVrfcCd();
            this.trnCode = externalReq.getTrnCode();
            this.trnReqAt = externalReq.getTrnReqAt();
            this.otpCommInfo = setOtpCommInfo();
        }

        public OtpCommInfo setOtpCommInfo() {
            return OtpCommInfo.builder()
                    .extTrnBswrDcd(OtpConst.EXT_TRN_OMSM)
                    .tlgrIttcd(OtpConst.OTP_TLGR_ITTCD_0210)
                    .extTrnDcd(OtpConst.OTP_TRN_DSNC_NO_200102)
                    .hndlIcd(ExternalCommConst.BN_CD_003)
                    .fnbbRpcdNo(null)
                    .trnTlgrSrn("1")
                    .tlsdHms(LocalDateTime.now().toString()).build();
        }

        public static VrfyVrfcCd ofVrfyVrfcCd(SecurityMediaApiCommand.VrfyVrfcCdApiCommand externalReq) {
            return new VrfyVrfcCd(externalReq);
        }
    }
}
