package com.project.otp.bank.infrastructure.external.client.otp.dto;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class OtpActivateRqst {
    @Getter
    @Builder
    @ToString
    public static class stepFirst { // 1차 활성화

        private String rnn;         // 고객아이디
        private Long secuCdn;       // 보안매체번호
        private String trnContent;  // 거래내용

        public stepFirst(String rnn, Long secuCdn, String trnContent) {
            this.rnn = rnn;
            this.secuCdn = secuCdn;
            this.trnContent = trnContent;
        }

        public static stepFirst ofStepFirst(String rnn, Long secuCdn, String trnContent) {
            return new stepFirst(rnn, secuCdn, trnContent);
        }

    }
}
