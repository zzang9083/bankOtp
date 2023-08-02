package com.project.otp.external.comm.builder;

import com.project.otp.external.kftc.otp.dto.comm.ApiInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class ClientMonoBuilder {
    public<Q,R> R buildFor(ApiInfo apiInfo, Q requestDto, Class<R> responseDto) {

        ClientRequestFrame clientRequestFrame = frameOf(apiInfo, requestDto);
        return buildMonoToPost(clientRequestFrame, responseDto);

    }


    private <R> R  buildMonoToPost(ClientRequestFrame request, Class<R> responseDto) {

        return WebClient.builder()
                .baseUrl(request.getHost()).build().post()
                .uri(uriBuilder -> uriBuilder.path(request.getPath()).build())
                .headers(header -> request.getHeaders().forEach(each -> header.add(each.getHeaderKey(), each.getHeaderValue())))
                .bodyValue(request.getRequestBody())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, res -> res.bodyToMono(String.class).map(IllegalStateException::new))
                .onStatus(HttpStatus::is5xxServerError, res -> res.bodyToMono(String.class).map(IllegalStateException::new))
                .bodyToMono(responseDto)
                .block();
    }
    protected abstract<Q> ClientRequestFrame frameOf(ApiInfo apiInfo, Q requestDto);
    protected abstract Class<? extends PlaceResponse> supportType();

}
