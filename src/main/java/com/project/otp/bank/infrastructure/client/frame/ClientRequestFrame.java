package com.project.otp.bank.infrastructure.client.frame;

import lombok.Builder;
import lombok.Getter;


import java.util.List;

public class ClientRequestFrame<Q> {
    @Getter
    private final String host;
    @Getter
    private final String path;
    @Getter
    private final List<ClientRequestHeader> headers;

    private final Q requestBody;


    @Builder
    public ClientRequestFrame(
            String host,
            String path,
            List<ClientRequestHeader> headers,
            Q requestBody
    ) {
        this.host = host;
        this.path = path;
        this.headers = headers;
        this.requestBody = requestBody;
    }


    @Getter
    public static class ClientRequestHeader {
        private final String headerKey;
        private final String headerValue;

        @Builder
        public ClientRequestHeader(String headerKey, String headerValue) {
            this.headerKey = headerKey;
            this.headerValue = headerValue;
        }

        public String getHeaderKey() {
            return headerKey;
        }

        public String getHeaderValue() {
            return headerValue;
        }
    }

    public Q getRequestBody() {
        return requestBody;
    }

}
