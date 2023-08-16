package com.project.otp.bank.application.securityMedia;

import com.project.otp.bank.domain.customer.service.CustomerService;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;
import com.project.otp.bank.domain.securityMedia.model.Token;
import com.project.otp.bank.domain.securityMedia.service.SecurityMediaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecurityMediaFacade {

    private final CustomerService customerService;

    private final SecurityMediaService securityMediaService;
    public SecurityMediaFacade(CustomerService customerService, SecurityMediaService securityMediaService) {
        this.customerService = customerService;
        this.securityMediaService = securityMediaService;
    }

    @Transactional
    public Token registerOtp(SecurityMediaCommand.RegisterSecurityMediaRequest req) { //디지털otp 발급

        // 고객 디지털 otp 생성
        SecurityMedia newOtp = securityMediaService.makeSecurityMedia(req, SecurityMediaType.DIGITAL_OTP);

//        CustomerInfo customerInfo = customerService.findOptionalCustomerByRnn(req.getRnn());
//
//        Token newToken = null;
//        if (findCustomer.verifySecurityMedia()) {
//
//
//            // 대외거래(요청) 이력 생성
//            //ExternalTrnInfo newTrn = externalService.saveExternalTrnInfo(externalTrnInfo);
//
//            // 금결원 디지털 otp 생성 요청
//            newToken = otpRepository.reqOtpReg(findCustomer, newOtp);
//
//            // 대외거래(응답) 이력 업데이트
//            //ExternalTrnInfo returnTrn = externalService.findById(newTrn.getExternalTrnId());
//
//            // 토큰세팅
//            newOtp.addToken(newToken);
//        }
//
//        return newToken;
    }

//    private final SecurityMediaRepository securityMediaRepository;
//
//
//    public SecurityMediaFacade(SecurityMediaRepository securityMediaRepository) {
//        this.securityMediaRepository = securityMediaRepository;
//    }
//
//    public SecurityMedia makeSecurityMedia(SecurityMediaType securityMediaType, Customer customer) {
//
//        SecurityMedia newDigitalOtp = SecurityMedia.issueDigitalOtp(SecurityMediaType.DIGITAL_OTP, customer);
//        securityMediaRepository.save(newDigitalOtp);
//        return newDigitalOtp;
//    }
}
