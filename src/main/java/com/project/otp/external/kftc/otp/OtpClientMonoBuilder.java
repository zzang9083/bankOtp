package com.project.otp.external.kftc.otp;

import com.project.otp.external.comm.builder.ClientMonoBuilder;
import com.project.otp.external.comm.builder.ClientRequestFrame;
import com.project.otp.external.kftc.otp.dto.comm.ApiInfo;
import com.project.otp.external.kftc.otp.comm.domain.OtpApiInfo;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class OtpClientMonoBuilder extends ClientMonoBuilder{

    private static final String CLIENT_ID_HEADER = "client-id-header";



    @Override
    protected<Q> ClientRequestFrame frameOf(ApiInfo apiInfo, Q requestDto) {

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
