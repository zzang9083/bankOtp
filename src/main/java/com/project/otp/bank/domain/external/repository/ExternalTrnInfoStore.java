package com.project.otp.bank.domain.external.repository;

import com.project.otp.bank.domain.external.model.ExternalTrnInfo;

public interface ExternalTrnInfoStore {

    ExternalTrnInfo store(ExternalTrnInfo externalTrnInfo);
}
