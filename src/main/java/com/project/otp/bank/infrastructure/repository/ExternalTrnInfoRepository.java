package com.project.otp.bank.infrastructure.repository;

import com.project.otp.bank.domain.model.bank.Customer;
import com.project.otp.bank.domain.model.external.ExternalTrnId;
import com.project.otp.bank.domain.model.external.ExternalTrnInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalTrnInfoRepository extends JpaRepository<ExternalTrnInfo, ExternalTrnId> {

}
