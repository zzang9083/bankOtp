package com.project.otp.bank.domain.customer.model;

import com.project.otp.bank.domain.external.model.ExternalTrnInfo;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import com.project.otp.bank.presentation.dto.OtpRegRqst;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id @GeneratedValue
    @Column(name = "cust_id")
    private Long custId;       // 고객 아이디
    private String custName;    // 고객명

    private char indvCorpDtlDcd; // 개인법인상세구분코드

    private String rnn; // 실명번호(사업자번호)

    private LocalDate birtYmd; // 생년월일

    private String cpn;     // 핸드폰번호

    private String custScd ; // 이용자상태

    private LocalDateTime frrgTs; // 최초등록시간

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<SecurityMedia> securityMedia;    // 보안매체

    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<Account> accountList = new ArrayList<>();  // 계좌목록

    @OneToMany(mappedBy = "customer", fetch = LAZY)
    private List<ExternalTrnInfo> externalTrnInfoList = new ArrayList<>();  // 대외거래 목록


    public Customer(String custName, String rnn, String cpn) {
        this.custName = custName;
        //this.rnn = EncryptionUtils.encryptSHA256(rnn);
        this.rnn = rnn;
        this.cpn = cpn;
    }

    public boolean existActiveSecurityMedia() {
        if(securityMedia != null
                && securityMedia.stream().filter(s -> s.getSccdScd().equals("REGISTER")).findAny().isPresent()) {
            throw new RuntimeException("이미 기등록된 보안매체가 등록되어있습니다. 보안매체 해제 후 등록 거래하세요.");
        }
        return false;
    }

    public SecurityMedia getActiveSecurityMedia(SecurityMediaType type) {
        return securityMedia.stream().filter(s -> s.getSecuType() == type)
                .filter(s -> s.getSccdScd().equals("REGISTER"))
                .findFirst().orElseThrow(() -> new RuntimeException("유효한 보안매체가 존재하지 않습니다."));

    }

    public void verifyOwnOtp(SecurityMediaType type, Long inputSecuCdn) {
        securityMedia.stream().filter(s -> s.getSecuType() == type)
                .filter(s -> s.getSccdScd().equals("REGISTER"))
                .filter(s -> s.getSecuCdn() == inputSecuCdn)
                .findFirst().orElseThrow(() -> new RuntimeException("입력 보안매체번호와 고객 보안매체번호가 일치하지 않습니다."));
    }
}
