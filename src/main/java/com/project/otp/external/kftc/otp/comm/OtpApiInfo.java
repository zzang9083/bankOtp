package com.project.otp.external.kftc.otp.comm;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtpApiInfo {

    private String apiKey;

    private String host;

    private String path;

    public OtpApiInfo(String apiKey, String host, String path) {
        this.apiKey = apiKey;
        this.host = host;
        this.path = path;
    }
}
