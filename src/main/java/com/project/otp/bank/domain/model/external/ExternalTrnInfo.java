package com.project.otp.bank.domain.model.external;

import com.project.otp.bank.domain.model.bank.Customer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

// 대외거래이력
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExternalTrnInfo {

    @Id
    @GeneratedValue
    @Column(name = "tlgr_mngm_no")
    private String tlgrMngmNo; // 거래전문번호 15

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cust_id")
    private Customer customer; // 고객id

    private LocalDate trnYmd; // 거래년월일 8

    private String extTrnBswrDcd; // 대외거래업무구분코드 4

    private String extTrnIntDcd; // 대외거래기관구분코드 4

    private String tlgrIttcd; // 전문종별코드 4

    private String extTrnDcd; // 대외거래구분코드 10

    private String hndlIcd; // 취급기관코드 10

    private String inttScd; // 기관상태코드 3

    private String fnbbRpcdNo; // 공동망응답코드번호 4

    private String tlsdHms; // 전문송신시각 6

    private String tlrcHms; // 전문수신시각 6


//    private String rsndHms; // 재전송시각

//    private String pcsnScd; // 처리상태코드 2

//    private String chnlComExtRpcdcon; // 채널공통대외응답코드내용 10
}
