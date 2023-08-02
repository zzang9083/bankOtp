package com.project.otp.bank.presentation.error.exception;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * controller 계층에서 발생하는 예외 및 에러를 처리하기 위한 에러 코드
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class ControllerErrorCode {

    // Common
//    INVALID_INPUT_VALUE("P001", " INVALID INPUT VALUE"),
//    METHOD_NOT_ALLOWED("P002", " NOT SUPPORT HTTP METHOD"),
//    INTERNAL_SERVER_ERROR("P004", "SERVER ERROR"),
//    NO_CONTENT("P005", "NO CONTENTS")
//            ;

    private final String code;
    private final String message;

    ControllerErrorCode(final String code, final String message) {
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
