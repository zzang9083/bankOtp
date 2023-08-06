package com.project.otp.bank.domain.model.bank;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id
    private String cusAcn;               // 계좌번호

    private String accountCusNm;        // 계좌소유주명

    private long totalAmount;           // 잔액

    private String accountStatus;       // 계좌상태

    private LocalDateTime frrgTs;       // 최초등록시간

    private LocalDateTime sysLsmdTs;    // 최종변경시간

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cust_id")
    private Customer customer;

}
