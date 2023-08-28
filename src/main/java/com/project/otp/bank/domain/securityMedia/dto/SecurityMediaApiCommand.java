package com.project.otp.bank.domain.securityMedia.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SecurityMediaApiCommand {

    @Getter
    @Builder
    @ToString
    public static class ActivateOtpStepFirstApiCommand { // 1차 활성화 대외요청

        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String trnContent; // 거래내역


    }

    @Getter
    @Builder
    @ToString
    public static class ActivateOtpStepSecondApiCommand { // 2차 활성화 대외요청

        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String token; // 토큰값



    }
    @Getter
    @Builder
    @ToString
    public static class VrfyVrfcCdApiCommand { // 인증번호 검증 요청
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


    }
}
