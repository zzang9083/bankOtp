package com.project.otp.bank.domain.otp;

import com.project.otp.bank.domain.bank.Customer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SecurityMedia {

    @Id
    private Long secuCdn; // 보안매체 일련번호

    @Enumerated(EnumType.STRING)
    private SecurityMediaType secuType; //보안매체구분

    @Enumerated(EnumType.STRING)
    private SecurityMediaStatus sccdScd; // 보안매체 상태코드

    private String isncYmd; // 발급년월일

    private String sysLsmdId; // 최종변경ID

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @OneToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;      // 고객id(fk)

    @OneToMany(mappedBy = "securityMedia")
    private List<SecurityMediaHistory> securityMediaHistoryList = new ArrayList<>();
}
