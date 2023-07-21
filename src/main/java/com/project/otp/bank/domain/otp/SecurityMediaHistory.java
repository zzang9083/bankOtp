package com.project.otp.bank.domain.otp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SecurityMediaHistory {

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "secuCdn")   // 보안매체 일련번호
    private SecurityMedia securityMedia;

    private long trnSrn;      // 거래일련번호

    private LocalDate trnYmd; // 거래년월일
}