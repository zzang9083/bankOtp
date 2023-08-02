package com.project.otp.external.kftc.otp.dto;

import com.project.otp.external.kftc.otp.dto.comm.OtpCommInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 등록응답

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OtpRegRqstRspn {

    private String prfmNm;      // 전문성명

    private String bswrCqrcgNo; // 업무고유식별번호

    private String cpn;         // 휴대번호

    private String birtYmd;     // 생년월일

    private String rgsnTs;      // 등록일시

    private Long secuCdn;       // 보안매체 일련번호

    private String tknNo; // 토큰번호 400

    private LocalDateTime isncTs; // 발급시간

    private LocalDateTime expyTs; // 만료시간

    private OtpCommInfo OtpCommInfo; // 거래 공통부

}
