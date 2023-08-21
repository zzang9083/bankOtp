//package com.project.otp.bank.application.customer;
//
//import com.project.otp.bank.domain.customer.model.Customer;
//import com.project.otp.bank.domain.customer.service.CustomerService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class CustomerFacade {
//
//    private final CustomerService customerService;
//
//    @Transactional
//    public Token findCustomerByRnn(Customer customer) { //디지털otp 발급
//
//        Customer findCustomer = customerRepository.findOptionalCustomerByRnn(customer.getRnn())
//                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));
//
//        Token newToken = null;
//        if (customer.verifySecurityMedia()) {
//            // 고객 디지털 otp 생성
//            SecurityMedia newOtp = securityMediaFacade.makeSecurityMedia(SecurityMediaType.DIGITAL_OTP, findCustomer);
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
//    }
//
//
//}
