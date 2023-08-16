package com.project.otp.bank.infrastructure.securityMedia;

import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import com.project.otp.bank.domain.securityMedia.repsitory.SecurityMediaStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityMediaStoreImpl implements SecurityMediaStore {

    private final SecurityMediaRepository securityMediaRepository;

    @Override
    public SecurityMedia store(SecurityMedia securityMedia) {

        return securityMediaRepository.save(securityMedia);
    }
}
