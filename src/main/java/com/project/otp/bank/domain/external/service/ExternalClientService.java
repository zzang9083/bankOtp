package com.project.otp.bank.domain.external.service;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.Token;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalClientService {
    Token getToken(Customer customer, SecurityMedia newOtp);


    void reqActivateOtpStepFirst(SecurityMediaCommand.ActivateOtpStepFirstToExternal externalReq);

}
