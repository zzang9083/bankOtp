package com.project.otp.bank.application;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.domain.otp.SecurityMedia;
import com.project.otp.bank.domain.otp.SecurityMediaType;
import com.project.otp.bank.repository.CustomerRepository;
import com.project.otp.external.kftc.otp.service.ExternalOtpRegService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final SecurityMediaService securityMediaService;

    private final ExternalOtpRegService externalOtpRegService;


    public CustomerService(CustomerRepository customerRepository, SecurityMediaService securityMediaService, ExternalOtpRegService externalOtpRegService) {
        this.customerRepository = customerRepository;
        this.securityMediaService = securityMediaService;
        this.externalOtpRegService = externalOtpRegService;

    }

    //디지털otp 발급
    public void regiterDigitalOtp(Customer customer) {

        // 고객 찾기, 검증
        Customer findCustomer = customerRepository.findOptionalCustomerByRnn(customer.getRnn())
                                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));
        List<SecurityMedia> securityMedia = customer.getSecurityMedia();
        if(securityMedia != null
                && securityMedia.stream().filter(s -> s.getSccdScd().equals("REGISTER")).findAny().isPresent()) {
            throw new RuntimeException("이미 기등록된 보안매체가 등록되어있습니다. 보안매체 해제 후 등록 거래하세요.");
        }

        // 고객 디지털 otp 생성
        SecurityMedia newOtp = securityMediaService.makeSecurityMedia(SecurityMediaType.DIGITAL_OTP, findCustomer);

        // 금결원 디지털 otp 생성 요청
        externalOtpRegService.reqOtpRegReq(findCustomer, newOtp);
    }

    public void terminateDigitalOtp(Customer customer) {
        //검증

        // 금결원 디지털 otp 해지 요청
    }


}
