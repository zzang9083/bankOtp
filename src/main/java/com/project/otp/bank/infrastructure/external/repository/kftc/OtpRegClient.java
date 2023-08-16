package com.project.otp.bank.infrastructure.external.repository.kftc;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.infrastructure.external.client.builder.ClientMonoBuilder;
import com.project.otp.bank.infrastructure.external.client.builder.otp.comm.ApiInfo;
import com.project.otp.bank.infrastructure.external.client.builder.otp.comm.OtpConst;
import com.project.otp.bank.infrastructure.external.client.builder.otp.dto.OtpRegRqstRspn;
import com.project.otp.bank.infrastructure.entity.OtpRegEntity;
import com.project.otp.bank.infrastructure.external.client.builder.otp.dto.OtpRegRqstRqst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Component
public class OtpRegClient implements Serializable {

    private final ClientMonoBuilder clientMonoBuilders;

    public OtpRegClient(ClientMonoBuilder clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }

    public OtpRegEntity reqOtpRegReq(Customer customer, SecurityMedia newOtp) {

        //API 정보 조립
        ApiInfo regApiInfo = ApiInfo.builder()
                                .host(OtpConst.OTP_HOST_URL)
                                .path(OtpConst.OTP_API_PATH_OTP_REG).build();

        //요청부 조립
        OtpRegRqstRqst otpRegRqstRqst = OtpRegRqstRqst.ofOtpRegRqstRqst(customer, newOtp);

        //otp 등록요청
        OtpRegRqstRspn otpRegRqstRspn
                = clientMonoBuilders.buildFor(regApiInfo, otpRegRqstRqst, OtpRegRqstRspn.class);


        // 응답 공통부 체크
        otpRegRqstRspn.checkFnbbRpcdNo();

        return otpRegRqstRspn.ofOtpRegEntity();
    }

//    private ErrorCode buildBizException(OtpRegRqstRspn otpRegRqstRspn) {
//        return new ErrorCode;
//    }

//    @Override
//    public OtpRegCmplRspn reqOtpRegCmpl(OtpRegCmplRqst otpRegCmplRqst) {
//        return null;
//    }
}
