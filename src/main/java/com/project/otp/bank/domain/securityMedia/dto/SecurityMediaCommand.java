package com.project.otp.bank.domain.securityMedia.dto;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaStatus;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class SecurityMediaCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterSecurityMediaRequest { // 등록요청

        private String custName;    // 고객명
        private String rnn;         // 실명번호(사업자번호)
        private String cpn;         // 휴대번호

        public SecurityMedia toEntity(SecurityMediaType secuType, Customer customer) {
            return SecurityMedia.builder()
                    .secuType(secuType)
                    .sccdScd(SecurityMediaStatus.REGISTER)
                    .isncYmd(LocalDate.now())
                    .expyYmd(LocalDate.of(9999,12,31))
                    .sysLsmdTs(LocalDateTime.now())
                    .customer(customer)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class ActivateOtpStepFirst { // 1차 활성화 요청

        private Long custId;       // 고객아이디

        private String trnContent; // 거래내역

        public ActivateOtpStepFirstToExternal toApiCommand(String rnn, Long secuCdn) {
            return ActivateOtpStepFirstToExternal.builder()
                    .secuCdn(secuCdn)
                    .rnn(rnn)
                    .trnContent(trnContent)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class ActivateOtpStepFirstToExternal { // 1차 활성화 대외요청

        private String rnn;         // 고객아이디
        private Long secuCdn;       // 보안매체번호
        private String trnContent;  // 거래내용

        public SecurityMedia toEntity(SecurityMediaType secuType, Customer customer) {
            return SecurityMedia.builder()
                    .secuType(secuType)
                    .sccdScd(SecurityMediaStatus.REGISTER)
                    .isncYmd(LocalDate.now())
                    .expyYmd(LocalDate.of(9999,12,31))
                    .sysLsmdTs(LocalDateTime.now())
                    .customer(customer)
                    .build();
        }
    }

}
