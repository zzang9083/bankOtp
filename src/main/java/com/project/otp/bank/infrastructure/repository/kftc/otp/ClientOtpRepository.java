package com.project.otp.bank.infrastructure.repository.kftc.otp;

import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.domain.model.otp.SecurityMedia;
import com.project.otp.bank.domain.model.otp.Token;
import com.project.otp.bank.domain.repository.OtpRepository;
import org.springframework.stereotype.Component;

@Component
public class ClientOtpRepository implements OtpRepository {

    private final OtpRegClient otpRegClient;

    public ClientOtpRepository(OtpRegClient otpRegClient) {
        this.otpRegClient = otpRegClient;
    }

    @Override
    public Token reqOtpReg(Customer findCustomer, SecurityMedia newOtp) {
        return otpRegClient.reqOtpRegReq(findCustomer, newOtp).convert();
    }
}
