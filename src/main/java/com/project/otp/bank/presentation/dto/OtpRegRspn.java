package com.project.otp.bank.presentation.dto;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import lombok.Getter;

@Getter
public class OtpRegRspn {


    private String custName;    // 고객명

    private String rnn;         // 실명번호(사업자번호)

    private String cpn;         // 휴대번호

    private String tknNo;       // 토큰번호

    public OtpRegRspn(SecurityMediaInfo.Main securityMediaInfo) {
        this.custName = securityMediaInfo.getCustomer().getCustName();
        this.rnn = securityMediaInfo.getCustomer().getRnn();
        this.cpn = securityMediaInfo.getCustomer().getCpn();
        this.tknNo = securityMediaInfo.getToken().getTknNo();
    }
}
