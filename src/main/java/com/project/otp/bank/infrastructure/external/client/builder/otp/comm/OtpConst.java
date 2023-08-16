package com.project.otp.bank.infrastructure.external.client.builder.otp.comm;

import com.project.otp.bank.domain.external.model.ExternalCommConst;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OtpConst {

    //거래은행코드
    public static final Set<String> BN_CD = new HashSet<String>(
            Arrays.asList(ExternalCommConst.BN_CD_001    //한국은행
                    , ExternalCommConst.BN_CD_002    //한국산업은행
                    , ExternalCommConst.BN_CD_003    //중소기업은행은행
                    , ExternalCommConst.BN_CD_004    //국민은행
                    , ExternalCommConst.BN_CD_005    //하나은행
                    , ExternalCommConst.BN_CD_006    //국민은행
                    , ExternalCommConst.BN_CD_007    //수협은행
                    , ExternalCommConst.BN_CD_008    //한국수출입은행
                    , ExternalCommConst.BN_CD_009    //수협은행
                    , ExternalCommConst.BN_CD_010    //농협은행
            ));


    //otp 공동센터 HOST URL
    public static final String OTP_HOST_URL = "http://localhost:8081/";

    //otp 공동센터 PATH URL
    public static final String OTP_API_PATH_OTP_REG   = "/kftc/otp/register";             // 거래구분코드 OTP등록 요청
    public static final String OTP_API_PATH_OTP_TMN   = "/kftc/otp/terminate";            // 거래구분코드 OTP해지 요청

    // 대외거래구분코드
    public static final String OTP_TRN_DSNC_NO_100101   = "100101";             // 거래구분코드 OTP등록 요청
    public static final String OTP_TRN_DSNC_NO_100102   = "100102";             // 거래구분코드 OTP등록 승인
    public static final String OTP_TRN_DSNC_NO_100103   = "100103";             // 거래구분코드 OTP등록 완료(대면)
    public static final String OTP_TRN_DSNC_NO_100104   = "100104";             // 거래구분코드 OTP등록 완료(비대면)
    public static final String OTP_TRN_DSNC_NO_100105   = "100105";             // 거래구분코드 OTP등록 승인(비대면)
    public static final String OTP_TRN_DSNC_NO_100106   = "100106";             // 거래구분코드 비대면실명확인완료통지
    public static final String OTP_TRN_DSNC_NO_100201   = "100201";             // 거래구분코드 온라인 재등록
    public static final String OTP_TRN_DSNC_NO_100202   = "100202";             // 거래구분코드 인앱 온라인 재등록
    public static final String OTP_TRN_DSNC_NO_100301   = "100301";             // 거래구분코드 공동앱 비밀번호 재등록
    public static final String OTP_TRN_DSNC_NO_100302   = "100302";             // 거래구분코드 인앱 비밀번호 변경
    public static final String OTP_TRN_DSNC_NO_100303   = "100303";             // 거래구분코드 연계 접근토큰 등록변경

    public static final String OTP_TRN_DSNC_NO_400101   = "400101";             // 거래구분코드 사고신고
    public static final String OTP_TRN_DSNC_NO_400102   = "400102";             // 거래구분코드 사고신고 철회
    public static final String OTP_TRN_DSNC_NO_400201   = "400201";             // 거래구분코드 등록해지
    public static final String OTP_TRN_DSNC_NO_400301   = "400301";             // 거래구분코드 이용자정보변경
    public static final String OTP_TRN_DSNC_NO_400401   = "400401";             // 거래구분코드 오류건수 초기화
    public static final String OTP_TRN_DSNC_NO_400501   = "400501";             // 거래구분코드 OTP 이용시간관리 요청

    public static final String OTP_TRN_DSNC_NO_300101   = "300101";             // 거래구분코드 OTP 상태조회
    public static final String OTP_TRN_DSNC_NO_500101   = "500101";             // 거래구분코드 이용기관 조회

    public static final String OTP_TRN_DSNC_NO_200101   = "200101";             // 거래구분코드 OTP 활성화
    public static final String OTP_TRN_DSNC_NO_200111   = "200111";             // 거래구분코드 OTP 활성화(인앱)
    public static final String OTP_TRN_DSNC_NO_200121   = "200121";             // 거래구분코드 OTP 시각장애인 인증확인
    public static final String OTP_TRN_DSNC_NO_200102   = "200102";             // 거래구분코드 인증번호 검증

    public static final String OTP_TRN_DSNC_NO_800301   = "800301";             // 거래구분코드 시스템상태확인

    // 전문종별코드
    public static final String OTP_TLGR_ITTCD_0100   = "0100";                  // 전문종별코드 보안카드 등록 요청
    public static final String OTP_TLGR_ITTCD_0110   = "0110";                  // 전문종별코드 보안카드 등록 응답
    public static final String OTP_TLGR_ITTCD_0400   = "0400";                  // 전문종별코드 보안카드 관리 요청
    public static final String OTP_TLGR_ITTCD_0410   = "0410";                  // 전문종별코드 보안카드 관리 응답
    public static final String OTP_TLGR_ITTCD_0300   = "0300";                  // 전문종별코드 보안카드 상태조회 요청
    public static final String OTP_TLGR_ITTCD_0310   = "0310";                  // 전문종별코드 보안카드 상태조회 응답
    public static final String OTP_TLGR_ITTCD_0200   = "0200";                  // 전문종별코드 보안카드 인증 요청
    public static final String OTP_TLGR_ITTCD_0210   = "0210";                  // 전문종별코드 보안카드 인증 응답
    public static final String OTP_TLGR_ITTCD_0800   = "0800";                  // 전문종별코드 보안카드 망관리 요청
    public static final String OTP_TLGR_ITTCD_0810   = "0810";                  // 전문종별코드 보안카드 망관리 응답


    // 대외거래구분코드
    public static final String EXT_TRN_OMSM   = "OMSM";                         // 대외거래구분코드 스마트 보안카드




}
