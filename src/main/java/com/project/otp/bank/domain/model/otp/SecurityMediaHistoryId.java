package com.project.otp.bank.domain.model.otp;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class SecurityMediaHistoryId implements Serializable {

    private Long secuCdn;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long trnSrn;      // 거래일련번호
}
