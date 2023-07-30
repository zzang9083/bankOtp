package com.project.otp.external.kftc.otp.client;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.repository.CustomerRepository;
import com.project.otp.external.comm.builder.ClientMonoBuilder;
import com.project.otp.external.comm.domain.ApiInfo;
import com.project.otp.external.kftc.otp.comm.domain.OtpConst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRspn;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;
import com.project.otp.external.kftc.otp.service.OtpRegService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OtpRegClient implements OtpRegService {

    private final ClientMonoBuilder clientMonoBuilders;

    private final CustomerRepository customerRepository;


    public OtpRegClient(ClientMonoBuilder clientMonoBuilders, CustomerRepository customerRepository) {
        this.clientMonoBuilders = clientMonoBuilders;
        this.customerRepository = customerRepository;
    }

    @Override
    public OtpRegRqstRspn reqOtpRegReq(Customer customer) {

        //요청 사용자 찾기
        Customer findCustomer
                = customerRepository.findOptionalCustomerByRnn(customer.getRnn())
                        .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));

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
