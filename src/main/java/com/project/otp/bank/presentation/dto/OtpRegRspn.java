package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.model.otp.Token;

public class OtpRegRspn {


    private String custName;    // 고객명

    private String rnn;         // 실명번호(사업자번호)

    private String cpn;         // 휴대번호

    private String tknNo;       // 토큰번호

    public OtpRegRspn(String custName, String rnn, String cpn, String tknNo) {
        this.custName = custName;
        this.rnn = rnn;
        this.cpn = cpn;
        this.tknNo = tknNo;
    }

    public static OtpRegRspn of(OtpRegRqst otpRegRqst, Token token) {
        return new OtpRegRspn(otpRegRqst.getCustName(), otpRegRqst.getRnn(), otpRegRqst.getCpn()
                             ,token.getTknNo());

    }
}
