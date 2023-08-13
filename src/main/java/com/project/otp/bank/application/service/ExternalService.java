package com.project.otp.bank.application.service;

import com.project.otp.bank.domain.model.external.ExternalTrnId;
import com.project.otp.bank.domain.model.external.ExternalTrnInfo;
import com.project.otp.bank.infrastructure.repository.ExternalTrnInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalService {

    private final ExternalTrnInfoRepository externalTrnInfoRepository;

    public ExternalService(ExternalTrnInfoRepository externalTrnInfoRepository) {
        this.externalTrnInfoRepository = externalTrnInfoRepository;
    }

    public ExternalTrnInfo saveExternalTrnInfo(ExternalTrnInfo externalTrnInfo) {

        return externalTrnInfoRepository.save(externalTrnInfo);
    }

    public ExternalTrnInfo findById(ExternalTrnId externalTrnId) {
        ExternalTrnInfo findTrn = externalTrnInfoRepository.findById(externalTrnId)
                                    .orElseThrow(() -> new RuntimeException("존재하지 않는 거래"));

        return findTrn;
    }
}
