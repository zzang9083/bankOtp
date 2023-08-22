package com.project.otp.bank.domain.securityMedia.service;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.customer.repository.CustomerReader;
import com.project.otp.bank.domain.external.service.ExternalClientService;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaApiCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaApiInfo;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import com.project.otp.bank.domain.securityMedia.model.Token;
import com.project.otp.bank.domain.securityMedia.repsitory.SecurityMediaStore;
import com.project.otp.bank.domain.securityMedia.repsitory.TokenStore;
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

    private final TokenStore tokenStore;
    private final ExternalClientService externalClientService;

    @Override
    @Transactional
    public SecurityMediaInfo.Main issueSecurityMedia(SecurityMediaCommand.RegisterSecurityMediaRequest req, SecurityMediaType type) {

        // 요청고객 찾기
        Customer customer = customerReader.findCustomerByRnn(req.getRnn());

        SecurityMedia newOtp = null;

        if(!customer.existActiveSecurityMedia()) {
            // otp 신규
            SecurityMedia initOtp = req.toEntity(SecurityMediaType.DIGITAL_OTP, customer);
            newOtp  = securityMediaStore.store(initOtp);

            // 토큰 발급 요청
            Token newToken = externalClientService.getToken(customer, newOtp);
            newOtp.addToken(newToken);
            tokenStore.store(newToken);
        }
        return new SecurityMediaInfo.Main(newOtp);
    }

    @Override
    @Transactional
    public SecurityMediaInfo.ActivateOtpStepFirst activateOtpStepFirst(SecurityMediaCommand.ActivateOtpStepFirst req) {
        // 요청고객 FIND
        Customer customer = customerReader.findCustomerById(req.getCustId());

        // 유효 디지털 otp FIND
        SecurityMedia activeOtp = customer.getActiveSecurityMedia(SecurityMediaType.DIGITAL_OTP);

        // 대외거래 요청부 조립
        SecurityMediaApiCommand.ActivateOtpStepFirstApiCommand apiReq
                = req.toApiCommand(customer, activeOtp, req);

        // 1차 활성화 요청
        SecurityMediaApiInfo.ActivateOtpStepFirst apiRepn
                = externalClientService.reqActivateOtpStepFirst(apiReq);

        // 공통부 보고 응답처리


        return SecurityMediaInfo.ActivateOtpStepFirst.of(apiRepn);

    }
}
