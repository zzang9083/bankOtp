package com.project.otp.bank.controller.otp;

import com.project.otp.bank.controller.dto.OtpRegRqst;
import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;
import com.project.otp.external.kftc.otp.service.OtpRegService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank/otp")
public class OtpRegController {

    private final OtpRegService otpRegService;

    public OtpRegController(OtpRegService otpRegService) {
        this.otpRegService = otpRegService;
    }

    @PostMapping("/register")
    public void regOtp(@RequestBody OtpRegRqst otpRegRqst) {
        OtpRegRqstRspn otpRegRqstRspn = otpRegService.reqOtpRegReq(Customer.ofCustomer(otpRegRqst));

    }


}
