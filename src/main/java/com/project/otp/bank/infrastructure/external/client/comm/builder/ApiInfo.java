package com.project.otp.bank.infrastructure.external.client.comm.builder;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApiInfo {

    private String apiKey;
    private String host;
    private String path;

    public ApiInfo(){

    }


    @Builder
    public ApiInfo(String apiKey, String host, String path) {
        this.apiKey = apiKey;
        this.host = host;
        this.path = path;
    }
}
