package com.project.otp.external.kftc.otp.service;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.domain.otp.SecurityMedia;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRspn;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;


public interface ExternalOtpRegService {

    public OtpRegRqstRspn reqOtpRegReq(Customer customer, SecurityMedia securityMedia);

    public OtpRegCmplRspn reqOtpRegCmpl(OtpRegCmplRqst otpRegCmplRqst);

}
