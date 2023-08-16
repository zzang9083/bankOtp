package com.project.otp.bank.infrastructure.external.repository;

import com.project.otp.bank.domain.external.model.ExternalTrnId;
import com.project.otp.bank.domain.external.model.ExternalTrnInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalTrnInfoRepository extends JpaRepository<ExternalTrnInfo, ExternalTrnId> {

}
