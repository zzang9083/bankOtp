package com.project.otp.bank.domain.securityMedia.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

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
}
