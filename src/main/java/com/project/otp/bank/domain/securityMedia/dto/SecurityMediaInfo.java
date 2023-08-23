package com.project.otp.bank.domain.securityMedia.dto;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.model.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SecurityMediaInfo {



    @Getter
    @ToString
    public static class Main {
        private Long secuCdn; // 보안매체 일련번호

        private SecurityMediaType secuType; //보안매체구분

        private SecurityMediaStatus sccdScd; // 보안매체 상태코드

        private LocalDate isncYmd; // 발급년월일

        private LocalDate expyYmd; // 만료년월일

        private LocalDateTime sysLsmdTs; // 최종변경시간

        private Customer customer;      // 고객id(fk)

        private Token token;    // 토큰번호

        private List<SecurityMediaHistory> securityMediaHistoryList = new ArrayList<>();


        public Main(SecurityMedia securityMedia) {
            this.secuCdn = securityMedia.getSecuCdn();
            this.secuType = securityMedia.getSecuType();
            this.sccdScd = securityMedia.getSccdScd();
            this.isncYmd = securityMedia.getIsncYmd();
            this.expyYmd = securityMedia.getExpyYmd();
            this.sysLsmdTs = securityMedia.getSysLsmdTs();
            this.customer = securityMedia.getCustomer();
            this.token = securityMedia.getActiveToken();
            this.securityMediaHistoryList = securityMedia.getSecurityMediaHistoryList();
        }
    }

    @Getter
    @ToString
    @Builder
    public static class ActivateOtpStepFirst {

        private long trnCode;         // 거래코드

        private String otpStateCode; // otp상태코드

        private int authErrCnt;      // 인증오류횟수



        public static ActivateOtpStepFirst of(SecurityMediaApiInfo.ActivateOtpStepFirst apiRepn) {
            return ActivateOtpStepFirst.builder()
                    .trnCode(apiRepn.getTrnCode())
                    .otpStateCode(apiRepn.getOtpStateCode())
                    .authErrCnt(apiRepn.getAuthErrCnt())
                    .build();
        }
    }

    @Getter
    @ToString
    @Builder
    public static class ActivateOtpStepSecond {

        private String custName;    // 고객명

        private String rnn; // 실명번호(사업자번호)

        private String cpn;     // 핸드폰번호

        private LocalDate birtYmd; // 생년월일

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd; // 사용용도(1: 접근매체, 2: 추가인증)

        private String token; // 토큰값
        public static ActivateOtpStepSecond of(SecurityMediaApiInfo.ActivateOtpStepSecond apiRepn) {
            return ActivateOtpStepSecond.builder()
                    .custName(apiRepn.getCustName())
                    .rnn(apiRepn.getRnn())
                    .cpn(apiRepn.getCpn())
                    .birtYmd(apiRepn.getBirtYmd())
                    .secuCdn(apiRepn.getSecuCdn())
                    .usageCd(apiRepn.getUsageCd())
                    .token(apiRepn.getToken())
                    .build();
        }
    }
}
