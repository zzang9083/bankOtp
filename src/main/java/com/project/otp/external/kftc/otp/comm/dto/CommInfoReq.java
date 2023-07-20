package com.project.otp.external.kftc.otp.comm.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CommInfoReq {

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

    private String trnTlgrSrn; // 거래전문일련번호 8

//    private String rsndHms; // 재전송시각

//    private String pcsnScd; // 처리상태코드 2

//    private String chnlComExtRpcdcon; // 채널공통대외응답코드내용 10
}
