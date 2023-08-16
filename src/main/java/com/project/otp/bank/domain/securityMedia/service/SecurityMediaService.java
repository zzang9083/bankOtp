package com.project.otp.bank.domain.securityMedia.service;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;

public interface SecurityMediaService {


    public SecurityMediaInfo makeSecurityMedia(SecurityMediaCommand.RegisterSecurityMediaRequest req, SecurityMediaType type);
}
