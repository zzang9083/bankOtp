package com.project.otp.bank.domain.external.repository;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.Token;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalRepository {

    Token reqOtpReg(Customer customer, SecurityMedia newOtp);
}
