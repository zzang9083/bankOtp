package com.project.otp.external.kftc.otp.client;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.domain.otp.SecurityMedia;
import com.project.otp.bank.domain.otp.SecurityMediaType;
import com.project.otp.bank.repository.CustomerRepository;
import com.project.otp.bank.repository.SecurityMediaRepository;
import com.project.otp.external.comm.builder.ClientMonoBuilder;
import com.project.otp.external.comm.domain.ApiInfo;
import com.project.otp.external.kftc.otp.dto.comm.OtpConst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRspn;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;
import com.project.otp.external.kftc.otp.service.OtpRegService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OtpRegClient implements OtpRegService {

    private final ClientMonoBuilder clientMonoBuilders;

    private final CustomerRepository customerRepository;

    private final SecurityMediaRepository securityMediaRepository;


    public OtpRegClient(ClientMonoBuilder clientMonoBuilders, CustomerRepository customerRepository, SecurityMediaRepository securityMediaRepository) {
        this.clientMonoBuilders = clientMonoBuilders;
        this.customerRepository = customerRepository;
        this.securityMediaRepository = securityMediaRepository;
    }

    @Override
    public OtpRegRqstRspn reqOtpRegReq(Customer customer) {

        //요청 사용자 찾기
        Customer findCustomer
                = customerRepository.findOptionalCustomerByRnn(customer.getRnn())
                        .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));

        //OTP 검증 및 생성
        List<SecurityMedia> securityMedia = findCustomer.getSecurityMedia();
        if(securityMedia != null
        && securityMedia.stream().filter(s -> s.getSccdScd().equals("REGISTER")).findAny().isPresent()) {
            throw new RuntimeException("이미 기등록된 보안매체가 등록되어있습니다. 보안매체 해제 후 등록 거래하세요.");
        }
        SecurityMedia newOtp = findCustomer.issueSecurityMedia(SecurityMediaType.DIGITAL_OTP, findCustomer);
        securityMediaRepository.saveAndFlush(newOtp);



        //API 정보 조립
        ApiInfo regApiInfo = ApiInfo.builder()
                                .host(OtpConst.OTP_HOST_URL)
                                .path(OtpConst.OTP_PATH_REG).build();

        //요청부 조립
        OtpRegRqstRqst otpRegRqstRqst = OtpRegRqstRqst.ofOtpRegRqstRqst(findCustomer);



        //otp 등록요청
        OtpRegRqstRspn OtpRegRqstRspn
                = clientMonoBuilders.buildFor(regApiInfo, otpRegRqstRqst, OtpRegRqstRspn.class);

        return placeEntities.convert();
    }

    @Override
    public OtpRegCmplRspn reqOtpRegCmpl(OtpRegCmplRqst otpRegCmplRqst) {
        return null;
    }
}
