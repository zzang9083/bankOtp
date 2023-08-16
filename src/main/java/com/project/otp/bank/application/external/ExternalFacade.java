package com.project.otp.bank.application.external;

import com.project.otp.bank.domain.external.model.ExternalTrnId;
import com.project.otp.bank.domain.external.model.ExternalTrnInfo;
import com.project.otp.bank.infrastructure.external.repository.ExternalTrnInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class ExternalFacade {

    private final ExternalTrnInfoRepository externalTrnInfoRepository;

    public ExternalFacade(ExternalTrnInfoRepository externalTrnInfoRepository) {
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
