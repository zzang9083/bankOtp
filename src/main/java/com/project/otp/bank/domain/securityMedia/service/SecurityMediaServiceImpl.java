package com.project.otp.bank.domain.securityMedia.service;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.customer.service.CustomerReader;
import com.project.otp.bank.domain.external.repository.ExternalRepository;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import com.project.otp.bank.domain.securityMedia.model.Token;
import com.project.otp.bank.domain.securityMedia.repsitory.SecurityMediaStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityMediaServiceImpl implements SecurityMediaService {

    private final CustomerReader customerReader;
    private final SecurityMediaStore securityMediaStore;
    private final ExternalRepository externalRepository;

    @Override
    @Transactional
    public Customer makeSecurityMedia(SecurityMediaCommand.RegisterSecurityMediaRequest req, SecurityMediaType type) {

        // 요청고객 FIND
        Customer customer = customerReader.findCustomerByRnn(req.getRnn());

        if(!customer.existActiveSecurityMedia()) {
            // otp 신규
            SecurityMedia initOtp = req.toEntity(SecurityMediaType.DIGITAL_OTP, customer);
            SecurityMedia newOtp  = securityMediaStore.store(initOtp);

            // 토큰 발급 요청
            Token newToken =  externalRepository.reqOtpReg(customer, newOtp);
        }
        return null;
    }
}
