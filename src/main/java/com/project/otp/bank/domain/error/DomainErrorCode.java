package com.project.otp.bank.domain.error;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class DomainErrorCode implements ErrorCode{

    // BANK domain
    //INVALID_KEYWORD_ERROR("K001", " INVALID KEYWORD ERROR"),

    // OTP DOMAIN
    //INVALID_ADDRESS_ERROR("L001", " INVALID ADDRESS ERROR"),
            ;


    private final String code;
    private final String message;

    DomainErrorCode(final String code, final String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

}
