package com.project.otp.bank.infrastructure.external.repository.kftc;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.external.repository.ExternalRepository;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.Token;
import org.springframework.stereotype.Component;

@Component
public class ExternalRepositoryImpl implements ExternalRepository {

    private final OtpRegClient otpRegClient;

    public ExternalRepositoryImpl(OtpRegClient otpRegClient) {
        this.otpRegClient = otpRegClient;
    }

    @Override
    public Token reqOtpReg(Customer findCustomer, SecurityMedia newOtp) {
        return otpRegClient.reqOtpRegReq(findCustomer, newOtp).convert();
    }
}
