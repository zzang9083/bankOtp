package com.project.otp.bank.domain.securityMedia.dto;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.model.*;
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
}
