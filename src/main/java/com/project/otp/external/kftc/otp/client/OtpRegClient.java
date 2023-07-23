package com.project.otp.external.kftc.otp.client;

import com.project.otp.external.comm.builder.ClientMonoBuilder;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegCmplRspn;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRqst;
import com.project.otp.external.kftc.otp.dto.OtpRegRqstRspn;
import com.project.otp.external.kftc.otp.service.OtpRegService;


public class OtpRegClient implements OtpRegService {

    private final ClientMonoBuilder clientMonoBuilders;


    public OtpRegClient(ClientMonoBuilder clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }

    @Override
    public OtpRegRqstRspn reqOtpRegReq(OtpRegRqstRqst otpRegRqstRqst) {
        OtpRegRqstRspn otpRegRqstRspn = new OtpRegRqstRspn();
        OtpRegRqstRspn OtpRegRqstRspn = clientMonoBuilders.buildFor(otpRegRqstRqst, OtpRegRqstRspn.class);
        //.forEach(placeEntities::add);

        return placeEntities.convert();
    }

    @Override
    public OtpRegCmplRspn reqOtpRegCmpl(OtpRegCmplRqst otpRegCmplRqst) {
        return null;
    }
}
