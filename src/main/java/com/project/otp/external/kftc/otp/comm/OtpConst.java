package com.project.otp.external.kftc.otp.comm;

import com.project.otp.external.comm.ExternalCommConstant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OtpConst {

    //거래은행코드
    public static final Set<String> BN_CD = new HashSet<String>(
            Arrays.asList(ExternalCommConstant.BN_CD_001
                        ,ExternalCommConstant.BN_CD_002
                        ,ExternalCommConstant.BN_CD_003
                        ,ExternalCommConstant.BN_CD_004
                        ,ExternalCommConstant.BN_CD_005
                        ,ExternalCommConstant.BN_CD_006
                        ,ExternalCommConstant.BN_CD_007
                        ,ExternalCommConstant.BN_CD_008
                        ,ExternalCommConstant.BN_CD_009
                        ,ExternalCommConstant.BN_CD_010
            ));

    // 대외거래구분코드
    public static final String OTP_TRN_DSNC_NO_100101   = "100101";             // 거래구분코드 OTP등록 요청

    // 전문종별코드
    public static final String OTP_TLGR_ITTCD_0100   = "0100";                  // 전문종별코드 OTP등록 요청
    public static final String OTP_TLGR_ITTCD_0110   = "0110";                  // 전문종별코드 OTP등록 응답


    // 대외거래구분코드
    public static final String EXT_TRN_OMSM   = "OMSM";                         // 대외거래구분코드 스마트 보안카드




}
