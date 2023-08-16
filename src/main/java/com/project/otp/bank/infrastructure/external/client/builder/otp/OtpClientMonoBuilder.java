package com.project.otp.bank.infrastructure.external.client.builder.otp;

import com.project.otp.bank.infrastructure.external.client.builder.ClientMonoBuilder;
import com.project.otp.bank.infrastructure.external.client.builder.otp.comm.ApiInfo;
import com.project.otp.bank.infrastructure.external.client.frame.ClientRequestFrame;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class OtpClientMonoBuilder extends ClientMonoBuilder {

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

//    @Override
//    protected Class<? extends PlaceResponse> supportType() {
//        return NaverResponseBody.class;
//    }




}
