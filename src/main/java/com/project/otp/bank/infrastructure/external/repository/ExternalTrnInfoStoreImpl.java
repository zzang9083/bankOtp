package com.project.otp.bank.infrastructure.external.repository;

import com.project.otp.bank.domain.external.model.ExternalTrnInfo;
import com.project.otp.bank.domain.external.repository.ExternalTrnInfoStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExternalTrnInfoStoreImpl implements ExternalTrnInfoStore {

    private final ExternalTrnInfoRepository externalTrnInfoRepository;

    @Override
    public ExternalTrnInfo store(ExternalTrnInfo externalTrnInfo) {
        return externalTrnInfoRepository.save(externalTrnInfo);
    }
}
