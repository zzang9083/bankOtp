package com.project.otp.bank.infrastructure.external.client.otp;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.external.service.ExternalClientService;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.Token;
import com.project.otp.bank.infrastructure.external.client.comm.builder.ClientMonoBuilder;
import com.project.otp.bank.infrastructure.external.client.comm.builder.ApiInfo;
import com.project.otp.bank.infrastructure.external.client.otp.comm.OtpConst;
import com.project.otp.bank.infrastructure.external.client.otp.dto.OtpActivateRqst;
import com.project.otp.bank.infrastructure.external.client.otp.dto.OtpRegRqstRspn;
import com.project.otp.bank.infrastructure.external.client.otp.dto.OtpRegRqstRqst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExternalClientServiceImpl implements ExternalClientService {

    private final ClientMonoBuilder clientMonoBuilders;

    public ExternalClientServiceImpl(ClientMonoBuilder clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }

    public Token getToken(Customer customer, SecurityMedia newOtp) {

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
//        if(OtpConst.OTP_RPCD_0000.equals(otpRegRqstRspn.checkFnbbRpcdNo()) {
//            //정상처리
//        }
//        else {
//            //에러처리
//        }

        return otpRegRqstRspn.convert();
    }

    @Override
    public void reqActivateOtpStepFirst(SecurityMediaCommand.ActivateOtpStepFirstToExternal externalReq) {

        //API 정보 조립
        ApiInfo regApiInfo = ApiInfo.builder()
                .host(OtpConst.OTP_HOST_URL)
                .path(OtpConst.OTP_API_PATH_OTP_AUTH_S1).build();

        //요청부 조립
        OtpActivateRqst.stepFirst stepFirst
                = OtpActivateRqst.stepFirst.ofStepFirst(externalReq.getRnn(), externalReq.getSecuCdn(), externalReq.getTrnContent());

        //otp 등록요청
        OtpRegRqstRspn otpRegRqstRspn
                = clientMonoBuilders.buildFor(regApiInfo, stepFirst, OtpRegRqstRspn.class);

    }
}
