package com.project.otp.external.kftc.otp;

import com.project.otp.external.comm.builder.ClientMonoBuilder;
import com.project.otp.external.comm.builder.ClientRequestFrame;
import com.project.otp.external.kftc.otp.comm.OtpApiInfo;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class OtpClientMonoBuilder extends ClientMonoBuilder{

    private static final String CLIENT_ID_HEADER = "client-id-header";

    private final OtpApiInfo apiInfo;

    public OtpClientMonoBuilder(OtpApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    @Override
    protected<Q> ClientRequestFrame frameOf(Q requestDto) {

        return ClientRequestFrame.builder()
                .host(apiInfo.getHost())
                .path(apiInfo.getPath())
                .headers(Arrays.asList(
                        new ClientRequestFrame.ClientRequestHeader(CLIENT_ID_HEADER, apiInfo.getApiKey())
                ))
                .requestBody(requestDto)
                .build();
    }

    @Override
    protected Class<? extends PlaceResponse> supportType() {
        return NaverResponseBody.class;
    }




}
