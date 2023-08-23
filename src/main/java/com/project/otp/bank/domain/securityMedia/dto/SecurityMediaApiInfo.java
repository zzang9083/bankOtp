package com.project.otp.bank.domain.securityMedia.dto;

import com.project.otp.bank.infrastructure.external.client.otp.comm.OtpCommInfo;
import com.project.otp.bank.infrastructure.external.client.otp.dto.OtpActivateRspn;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

public class SecurityMediaApiInfo {

    @Getter
    @Builder
    @ToString
    public static class ActivateOtpStepFirst { // 1차 활성화 대외응답

        private long trnCode;         // 거래코드

        private String otpStateCode; // otp상태코드

        private int authErrCnt;      // 인증오류횟수

        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String trnContent; // 거래내역

        private OtpCommInfo otpCommInfo; // 거래 공통부

        public static SecurityMediaApiInfo.ActivateOtpStepFirst of(OtpActivateRspn.StepFirst stepFirstRspn) {
            return ActivateOtpStepFirst.builder()
                    .trnCode(stepFirstRspn.getTrnCode())
                    .otpStateCode(stepFirstRspn.getOtpStateCode())
                    .authErrCnt(stepFirstRspn.getAuthErrCnt())
                    .custName(stepFirstRspn.getCustName())
                    .rnn(stepFirstRspn.getRnn())
                    .cpn(stepFirstRspn.getCpn())
                    .birtYmd(stepFirstRspn.getBirtYmd())
                    .secuCdn(stepFirstRspn.getSecuCdn())
                    .usageCd(stepFirstRspn.getUsageCd())
                    .trnContent(stepFirstRspn.getTrnContent())
                    .otpCommInfo(stepFirstRspn.getOtpCommInfo())
                    .build();
        }
    }


    @Getter
    @Builder
    @ToString
    public static class ActivateOtpStepSecond {
        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String token; // 토큰값
        private OtpCommInfo otpCommInfo; // 거래 공통부

        public static ActivateOtpStepSecond of(OtpActivateRspn.StepSecond stepSecondRspn) {
            return ActivateOtpStepSecond.builder()
                    .custName(stepSecondRspn.getCustName())
                    .rnn(stepSecondRspn.getRnn())
                    .cpn(stepSecondRspn.getCpn())
                    .birtYmd(stepSecondRspn.getBirtYmd())
                    .secuCdn(stepSecondRspn.getSecuCdn())
                    .usageCd(stepSecondRspn.getUsageCd())
                    .token(stepSecondRspn.getToken())
                    .otpCommInfo(stepSecondRspn.getOtpCommInfo())
                    .build();
        }
    }
}
