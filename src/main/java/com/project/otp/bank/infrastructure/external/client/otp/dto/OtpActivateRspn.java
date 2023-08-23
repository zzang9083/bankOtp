package com.project.otp.bank.infrastructure.external.client.otp.dto;

import com.project.otp.bank.infrastructure.external.client.otp.comm.OtpCommInfo;
import lombok.Getter;

import java.time.LocalDate;

public class OtpActivateRspn {

    @Getter
    public static class StepFirst { // 1차 활성화
        
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
    }

    @Getter
    public static class StepSecond {

        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String token; // 토큰값

        private OtpCommInfo otpCommInfo; // 거래 공통부

    }
}
