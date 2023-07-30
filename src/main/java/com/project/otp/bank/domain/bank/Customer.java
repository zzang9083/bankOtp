package com.project.otp.bank.domain.bank;

import com.project.otp.bank.controller.dto.OtpRegDto;
import com.project.otp.bank.domain.otp.SecurityMedia;
import com.project.otp.bank.funtion.EncryptionUtils;
import com.project.otp.external.comm.domain.ExternalTrnInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;

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

    private String  birth; // 생년월일

    private String cpn;     // 핸드폰번호

    private String custScd ; // 이용자상태

    private LocalDateTime frrgTs; // 최초등록시간

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @OneToOne(mappedBy = "securityMedia", fetch = LAZY, cascade = CascadeType.ALL)
    private SecurityMedia securityMedia;    // 보안매체

    @OneToMany(mappedBy = "customer", fetch = LAZY, cascade = CascadeType.ALL)
    private List<Account> accountList = new ArrayList<>();  // 계좌목록

    @OneToMany(mappedBy = "customer", fetch = LAZY, cascade = CascadeType.ALL)
    private List<ExternalTrnInfo> externalTrnInfoList = new ArrayList<>();  // 대외거래 목록


    public Customer(String custName, String rnn, String cpn) {
        this.custName = custName;
        this.rnn = EncryptionUtils.encryptSHA256(rnn);
        this.cpn = cpn;
    }

    public static Customer ofCustomer(OtpRegDto otpRegDto) {
        return new Customer(otpRegDto.getCustName(), otpRegDto.getRnn(), otpRegDto.getCpn());
    }
}
