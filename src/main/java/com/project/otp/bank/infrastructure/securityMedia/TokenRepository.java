package com.project.otp.bank.infrastructure.securityMedia;

import com.project.otp.bank.domain.securityMedia.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
