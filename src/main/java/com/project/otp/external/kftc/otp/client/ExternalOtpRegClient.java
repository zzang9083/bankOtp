package com.project.otp.external.kftc.otp.client;

import com.project.otp.bank.domain.bank.Customer;
import com.project.otp.bank.domain.otp.SecurityMedia;
import com.project.otp.external.comm.builder.ClientMonoBuilder;
import com.project.otp.external.kftc.otp.dto.comm.ApiInfo;
import com.project.otp.external.kftc.otp.dto.comm.OtpCommInfo;
import com.project.otp.external.kftc.otp.dto.comm.OtpConst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRspn;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;
import com.project.otp.external.kftc.otp.service.ExternalOtpRegService;
import org.springframework.stereotype.Component;

@Component
public class ExternalOtpRegClient implements ExternalOtpRegService {

    private final ClientMonoBuilder clientMonoBuilders;

    public ExternalOtpRegClient(ClientMonoBuilder clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }

    @Override
    public OtpRegRqstRspn reqOtpRegReq(Customer customer, SecurityMedia newOtp) {

        //API 정보 조립
        ApiInfo regApiInfo = ApiInfo.builder()
                                .host(OtpConst.OTP_HOST_URL)
                                .path(OtpConst.OTP_PATH_REG).build();

        //요청부 조립
        OtpRegRqstRqst otpRegRqstRqst = OtpRegRqstRqst.ofOtpRegRqstRqst(customer, newOtp);



        //otp 등록요청
        OtpRegRqstRspn otpRegRqstRspn
                = clientMonoBuilders.buildFor(regApiInfo, otpRegRqstRqst, OtpRegRqstRspn.class);


        // 거래 이력 생성

        // 응답 공통부 체크
        checkFnbbRpcdNo(otpRegRqstRspn.getOtpCommInfo());

        // 토큰 부여
        newOtp.addToken(otpRegRqstRspn.);

        return placeEntities.convert();
    }

    private void checkFnbbRpcdNo(OtpCommInfo otpCommInfo) {
        String fnbbRpcdNo = otpCommInfo.getFnbbRpcdNo();

        switch (fnbbRpcdNo) {
            case "0000":

        }
    }

    @Override
    public OtpRegCmplRspn reqOtpRegCmpl(OtpRegCmplRqst otpRegCmplRqst) {
        return null;
    }
}
