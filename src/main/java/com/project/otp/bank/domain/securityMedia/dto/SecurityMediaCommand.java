package com.project.otp.bank.domain.securityMedia.dto;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaStatus;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class SecurityMediaCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterSecurityMediaRequest { // 등록요청

        @NotEmpty(message = "custName 는 필수값입니다")
        private String custName;    // 고객명

        @NotEmpty(message = "rnn 는 필수값입니다")
        private String rnn;         // 실명번호(사업자번호)

        @NotEmpty(message = "cpn 는 필수값입니다")
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

        private String usageCd;    // 사용용도

        private String trnContent; // 거래내역


        public SecurityMediaApiCommand.ActivateOtpStepFirstApiCommand toApiCommand(Customer customer, SecurityMedia activeOtp, ActivateOtpStepFirst req) {
            return SecurityMediaApiCommand.ActivateOtpStepFirstApiCommand.builder()
                    .custName(customer.getCustName())
                    .rnn(customer.getRnn())
                    .cpn(customer.getCpn())
                    .birtYmd(customer.getBirtYmd())
                    .secuCdn(activeOtp.getSecuCdn())
                    .usageCd(req.getUsageCd())
                    .trnContent(req.getTrnContent())
                    .build();

        }
    }

    @Getter
    @Builder
    @ToString
    public static class ActivateOtpStepSecond { // 2차 활성화 요청

        private Long custId;    // 고객 아이디

        private Long secuCdn;   // 보안매체 일련번호

        private String usageCd;    // 사용용도

        private String cpn;     // 핸드폰번호

        private String token;   // 토큰값


        public SecurityMediaApiCommand.ActivateOtpStepSecondApiCommand toApiCommand(Customer customer, ActivateOtpStepSecond req) {
            return SecurityMediaApiCommand.ActivateOtpStepSecondApiCommand.builder()
                    .custName(customer.getCustName())
                    .rnn(customer.getRnn())
                    .cpn(customer.getCpn())
                    .birtYmd(customer.getBirtYmd())
                    .secuCdn(req.getSecuCdn())
                    .usageCd(req.getUsageCd())
                    .token(req.getToken())
                    .build();

        }
    }

    @Getter
    @Builder
    @ToString
    public static class VrfyVrfcCdRqst { // 인증번호 검증 요청

        private Long custId;    // 고객 아이디

        private Long secuCdn; // 보안매체 일련번호

        private String usageCd;    // 사용용도

        private String cpn;     // 핸드폰번호

        private String token;   // 토큰번호

        private long trnCode;         // 거래코드

        private Long vrfcCd;    // 인증코드

        private LocalDateTime trnReqAt;     // 거래요청일시

        public SecurityMediaApiCommand.VrfyVrfcCdApiCommand toApiCommand(Customer customer, SecurityMediaCommand.VrfyVrfcCdRqst req) {
            return SecurityMediaApiCommand.VrfyVrfcCdApiCommand.builder()
                    .custName(customer.getCustName())
                    .rnn(customer.getRnn())
                    .cpn(customer.getCpn())
                    .birtYmd(customer.getBirtYmd())
                    .secuCdn(req.getSecuCdn())
                    .usageCd(req.getUsageCd())
                    .token(req.getToken())
                    .trnCode(req.getTrnCode())
                    .vrfcCd(req.getVrfcCd())
                    .trnReqAt(req.getTrnReqAt())
                    .build();

        }
    }



}
