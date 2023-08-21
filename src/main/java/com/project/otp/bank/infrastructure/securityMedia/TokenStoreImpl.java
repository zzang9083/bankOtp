package com.project.otp.bank.infrastructure.securityMedia;

import com.project.otp.bank.domain.securityMedia.model.Token;
import com.project.otp.bank.domain.securityMedia.repsitory.TokenStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenStoreImpl implements TokenStore {
    private final TokenRepository tokenRepository;

    @Override
    public Token store(Token token) {

        return tokenRepository.save(token);
    }
}
