package com.project.otp.external.comm.builder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.otp.external.comm.builder.ClientRequestFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

public abstract class ClientMonoBuilder {
    public<Q,R> R buildFor(Q requestDto, Class<R> responseDto) {
        //MultiValueMap<String, String> dtoMap = convertDtoToMap(req);
        ClientRequestFrame clientRequestFrame = frameOf(requestDto);
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
    protected abstract<Q> ClientRequestFrame frameOf(Q requestDto);
    protected abstract Class<? extends PlaceResponse> supportType();

}
