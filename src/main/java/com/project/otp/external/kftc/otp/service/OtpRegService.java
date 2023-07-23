package com.project.otp.external.kftc.otp.service;

import com.project.otp.external.kftc.otp.dto.OtpRegCmplRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRspn;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;

public interface OtpRegService {

    public OtpRegRqstRspn reqOtpRegReq(OtpRegRqstRqst otpRegRqstRqst);

    public OtpRegCmplRspn reqOtpRegCmpl(OtpRegCmplRqst otpRegCmplRqst);

}
