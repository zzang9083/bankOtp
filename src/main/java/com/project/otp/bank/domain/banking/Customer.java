package com.project.otp.bank.domain.banking;

import com.project.otp.bank.domain.otp.SecurityMedia;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id @GeneratedValue
    @Column(name = "cust_id")
    private Long custId;       // 고객 아이디

    private String custName;    // 고객명

    private String ebnkDcd;     // 뱅킹구분코드

    private char indvCorpDtlDcd; // 개인법인상세구분코드

    private String csm; // 사용자명

    private String rnn; // 실명번호(사업자번호)

    private String  birth; // 생년월일

    private String phNum; // 핸드폰번호

    private String usrScd ; // 이용자상태

    private LocalDateTime frrgTs; // 최초등록시간

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @OneToOne(mappedBy = "securityMedia", fetch = LAZY, cascade = CascadeType.ALL)
    private SecurityMedia securityMedia;    // 보안매체




}
