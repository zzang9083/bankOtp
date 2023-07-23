package com.project.otp.external.comm;




import com.project.otp.external.comm.builder.ClientMonoBuilder;

import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

public class ExternalRqstUtil {
    private final ClientMonoBuilder clientMonoBuilders;


    public ExternalRqstUtil(ClientMonoBuilder clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }
    @Override
    public Places requestSearchByKeyword(String keyword) {

        // WebClient 병렬 호출
        PlaceEntities placeEntities = new PlaceEntities(new ArrayList<>());
        clientMonoBuilders.stream()
                .parallel()
                .map(eachBuilder -> eachBuilder.buildFor(keyword))
                .map(eachMono ->  eachMono.share().block())
                .collect(toList())
                .forEach(placeEntities::add);

        return placeEntities.convert();
    }
}
