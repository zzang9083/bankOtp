package com.project.otp.bank.domain.model.external;

import com.project.otp.bank.domain.model.bank.Customer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

// 대외거래이력
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExternalTrnInfo {

    @EmbeddedId
    private ExternalTrnId externalTrnId;

    @MapsId("custId") //ExternalHistoryId.custId 매핑
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cust_id")
    private Customer customer; // 고객id


    private String extTrnBswrDcd; // 대외거래업무구분코드 4

    private String extTrnIntDcd; // 대외거래기관구분코드 4

    private String tlgrIttcd; // 전문종별코드 4

    private String extTrnDcd; // 대외거래구분코드 10

    private String hndlIcd; // 취급기관코드 10

    private String fnbbRpcdNo; // 공동망응답코드번호 4

    private String tlsdHms; // 전문송신시각 6

    private String tlrcHms; // 전문수신시각 6


}
