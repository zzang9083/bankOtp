package com.project.otp.bank.infrastructure.external.client.otp;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.external.service.ExternalClientService;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaApiCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaApiInfo;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.model.Token;
import com.project.otp.bank.infrastructure.external.client.comm.builder.ClientMonoBuilder;
import com.project.otp.bank.infrastructure.external.client.comm.builder.ApiInfo;
import com.project.otp.bank.infrastructure.external.client.otp.comm.OtpConst;
import com.project.otp.bank.infrastructure.external.client.otp.dto.OtpActivateRqst;
import com.project.otp.bank.infrastructure.external.client.otp.dto.OtpActivateRspn;
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
    public SecurityMediaApiInfo.ActivateOtpStepFirst reqActivateOtpStepFirst(SecurityMediaApiCommand.ActivateOtpStepFirstApiCommand externalReq) {

        //API 정보 조립
        ApiInfo regApiInfo = ApiInfo.builder()
                .host(OtpConst.OTP_HOST_URL)
                .path(OtpConst.OTP_API_PATH_OTP_AUTH_S1).build();

        //요청부 조립
        OtpActivateRqst.StepFirst stepFirst
                = OtpActivateRqst.StepFirst.ofStepFirst(externalReq);

        //otp 1차 활성화
        OtpActivateRspn.StepFirst stepFirstRspn
                = clientMonoBuilders.buildFor(regApiInfo, stepFirst, OtpActivateRspn.StepFirst.class);


        return SecurityMediaApiInfo.ActivateOtpStepFirst.of(stepFirstRspn);
    }

    @Override
    public SecurityMediaApiInfo.ActivateOtpStepSecond reqActivateOtpStepSecond(SecurityMediaApiCommand.ActivateOtpStepSecondApiCommand externalReq) {

        //API 정보 조립
        ApiInfo regApiInfo = ApiInfo.builder()
                .host(OtpConst.OTP_HOST_URL)
                .path(OtpConst.OTP_API_PATH_OTP_AUTH_S2).build();

        //요청부 조립
        OtpActivateRqst.StepSecond stepSecond
                = OtpActivateRqst.StepSecond.ofStepSecond(externalReq);

        //otp 2차 활성화
        OtpActivateRspn.StepSecond stepSecondRspn
                = clientMonoBuilders.buildFor(regApiInfo, stepSecond, OtpActivateRspn.StepSecond.class);


        return SecurityMediaApiInfo.ActivateOtpStepSecond.of(stepSecondRspn);
    }

    @Override
    public SecurityMediaApiInfo.VrfyVrfcCd reqVrfyVrfcCd(SecurityMediaApiCommand.VrfyVrfcCdApiCommand externalReq) {
        //API 정보 조립
        ApiInfo regApiInfo = ApiInfo.builder()
                .host(OtpConst.OTP_HOST_URL)
                .path(OtpConst.OTP_API_PATH_OTP_AUTH_VRFY).build();

        //요청부 조립
        OtpActivateRqst.VrfyVrfcCd vrfyVrfcCd
                = OtpActivateRqst.VrfyVrfcCd.ofVrfyVrfcCd(externalReq);

        //otp 인증번호 검증
        OtpActivateRspn.VrfyVrfcCd vrfyVrfcCdRspn
                = clientMonoBuilders.buildFor(regApiInfo, vrfyVrfcCd, OtpActivateRspn.VrfyVrfcCd.class);


        return SecurityMediaApiInfo.VrfyVrfcCd.of(vrfyVrfcCdRspn);
    }
}
