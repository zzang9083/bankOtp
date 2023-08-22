package com.project.otp.bank.domain.securityMedia.service;

import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaCommand;
import com.project.otp.bank.domain.securityMedia.dto.SecurityMediaInfo;
import com.project.otp.bank.domain.securityMedia.model.SecurityMediaType;

public interface SecurityMediaService {


    public SecurityMediaInfo.Main issueSecurityMedia(SecurityMediaCommand.RegisterSecurityMediaRequest req, SecurityMediaType type);

    public SecurityMediaInfo.ActivateOtpStepFirst activateOtpStepFirst(SecurityMediaCommand.ActivateOtpStepFirst req);

}
