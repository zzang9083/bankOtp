//package com.project.otp.external.comm.builder;
//
//import com.project.otp.external.comm.builder.ClientRequestFrame;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//public abstract class ClientMonoBuilder {
//    public Mono<PlaceEntities> buildFor(String keyword) {
//        ClientRequestFrame clientRequestFrame = frameOf(keyword);
//        return buildMono(clientRequestFrame);
//
//    }
//    private Mono<PlaceEntities> buildMono(ClientRequestFrame request) {
//        return  WebClient.builder()
//                .baseUrl(request.getHost()).build().get()
//                .uri(uriBuilder -> uriBuilder.path(request.getPath()).queryParams(request.getQueryParam()).build())
//                .headers(header -> request.getHeaders().forEach(each -> header.add(each.getHeaderKey(), each.getHeaderValue())))
//                .retrieve()
//                .onStatus(HttpStatus::is4xxClientError, res -> res.bodyToMono(String.class).map(IllegalStateException::new))
//                .onStatus(HttpStatus::is5xxServerError, res -> res.bodyToMono(String.class).map(IllegalStateException::new))
//                .bodyToMono(supportType())
//                .map(PlaceResponse::ofPlaces);
//    }
//
//    protected abstract ClientRequestFrame frameOf(String keyword);
//    protected abstract Class<? extends PlaceResponse> supportType();
//}
