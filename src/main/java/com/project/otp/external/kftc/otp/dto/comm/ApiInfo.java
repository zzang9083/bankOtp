package com.project.otp.external.kftc.otp.dto.comm;

import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
public class ApiInfo {

    private String apiKey;
    private String host;
    private String path;
}
