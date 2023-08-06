package com.project.otp.bank.domain.repository;

import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.domain.model.otp.SecurityMedia;
import com.project.otp.bank.domain.model.otp.Token;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository {

    Token reqOtpReg(Customer findCustomer, SecurityMedia newOtp);
}
