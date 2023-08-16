package com.project.otp.bank.domain.securityMedia.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SecurityMediaHistory {

    @EmbeddedId
    private SecurityMediaHistoryId securityMediaHistoryId;

    @MapsId("secuCdn") //SecurityMediaHistoryId.secuCdn 매핑
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "secu_cdn")   // 보안매체 일련번호
    private SecurityMedia securityMedia;


    @Enumerated(EnumType.STRING)
    private SecurityMediaStatus sccdScd; // 보안매체 상태코드

    private LocalDateTime trnTs; // 최종변경시간

}
