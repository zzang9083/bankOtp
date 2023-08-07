package com.project.otp.bank.domain.model.external;


import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Embeddable
@EqualsAndHashCode
public class ExternalTrnId implements Serializable {

    private Long custId; // 고객id

    private LocalDate trnYmd; // 거래년월일 8

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tlgr_mngm_no")
    private String tlgrMngmNo; // 전문관리번호 15 (기관코드 3 + seq : 12)


}
