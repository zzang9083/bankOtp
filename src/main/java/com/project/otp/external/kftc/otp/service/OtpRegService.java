package com.project.otp.external.kftc.otp.service;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRspn;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



public interface OtpRegService {

    public OtpRegRqstRspn reqOtpRegReq(Customer customer);

    public OtpRegCmplRspn reqOtpRegCmpl(OtpRegCmplRqst otpRegCmplRqst);

}
