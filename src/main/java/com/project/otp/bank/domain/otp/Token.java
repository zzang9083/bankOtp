package com.project.otp.bank.domain.otp;

import com.project.otp.bank.domain.bank.Customer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token {

    @Id
    private String usisNo; // 이용기관번호 10 pk

    private long isncSrn; // 발급일련번호 5 pk

    private String tknNo; // 토큰번호 400

    private String isncYmd; // 발급년월일

    private String expyYmd; // 만료년월일

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @OneToOne
    @JoinColumn(name = "secu_cdn")
    private SecurityMedia customer;      // 고객id(fk)

}
