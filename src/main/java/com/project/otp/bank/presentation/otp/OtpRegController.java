package com.project.otp.bank.presentation.otp;

import com.project.otp.bank.application.CustomerService;
import com.project.otp.bank.presentation.dto.OtpRegRqst;
import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.presentation.dto.OtpTerminateRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/otp")
public class OtpRegController {

    private final CustomerService customerService;

    public OtpRegController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public void regOtp(@RequestBody OtpRegRqst otpRegRqst) {
        customerService.regiter(Customer.ofCustomer(otpRegRqst));

    }

    @DeleteMapping("/terminate")
    public void terminateOtp(@RequestBody OtpTerminateRqst otpTerminateRqst) {
        customerService.issueSecurityMedia(Customer.ofCustomer(otpTerminateRqst));

    }


}
