package com.project.otp.bank.infrastructure.repository.kftc.otp;

import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.domain.error.BusinessException;
import com.project.otp.bank.domain.model.otp.SecurityMedia;
import com.project.otp.bank.infrastructure.client.builder.ClientMonoBuilder;
import com.project.otp.bank.infrastructure.client.builder.otp.comm.ApiInfo;
import com.project.otp.bank.infrastructure.client.builder.otp.comm.OtpConst;
import com.project.otp.bank.infrastructure.client.builder.otp.dto.OtpRegRqstRspn;
import com.project.otp.bank.infrastructure.entity.OtpRegEntity;
import com.project.otp.bank.infrastructure.client.builder.otp.dto.OtpRegRqstRqst;
import org.springframework.stereotype.Component;

import java.io.Serializable;

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
                                .path(OtpConst.OTP_PATH_REG).build();

        //요청부 조립
        OtpRegRqstRqst otpRegRqstRqst = OtpRegRqstRqst.ofOtpRegRqstRqst(customer, newOtp);

        //otp 등록요청
        OtpRegRqstRspn otpRegRqstRspn
                = clientMonoBuilders.buildFor(regApiInfo, otpRegRqstRqst, OtpRegRqstRspn.class);


        // 응답 공통부 체크
        try {
            otpRegRqstRspn.checkFnbbRpcdNo();
        } catch (BusinessException e) {
            //ErrorCode ed = buildBizException(otpRegRqstRspn);
        }

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
