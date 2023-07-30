package com.project.otp.bank.controller.dto;


import lombok.Getter;

@Getter
public class OtpRegDto {

    private String custName;    // 고객명

    private String rnn;         // 실명번호(사업자번호)

    private String cpn;         // 휴대번호

}
