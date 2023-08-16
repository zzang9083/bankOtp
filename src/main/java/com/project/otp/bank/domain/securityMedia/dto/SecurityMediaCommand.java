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
    public static class RegisterSecurityMediaRequest {

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

}
