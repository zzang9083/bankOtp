package com.project.otp.bank.domain.securityMedia.repsitory;

import com.project.otp.bank.domain.securityMedia.model.Token;

public interface TokenStore {
    Token store(Token token);
}
