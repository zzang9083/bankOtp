package com.project.otp.bank.domain.securityMedia.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token {

    @Id
    private String usisNo; // 이용기관번호 10 pk

    private long isncSrn; // 발급일련번호 5 pk

    private String tknNo; // 토큰번호 400

    private TokenStatus tokenStatus; // 토큰상태

    private LocalDateTime isncTs; // 발급시간

    private LocalDateTime expyTs; // 만료시간

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @ManyToOne
    @JoinColumn(name = "secu_cdn")
    private SecurityMedia securityMedia;   // 보안매체

    @Builder
    public Token(String usisNo, String tknNo, LocalDateTime isncTs, LocalDateTime expyTs, LocalDateTime sysLsmdTs) {
        this.usisNo = usisNo;
        this.tknNo = tknNo;
        this.isncTs = isncTs;
        this.expyTs = expyTs;
        this.sysLsmdTs = sysLsmdTs;
    }

}
