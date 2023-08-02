package com.project.otp.bank.domain.otp;

import com.project.otp.bank.domain.bank.Customer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SecurityMedia {

    @Id
    @Column(name = "secu_cdn")
    @GeneratedValue
    private Long secuCdn; // 보안매체 일련번호

    @Enumerated(EnumType.STRING)
    private SecurityMediaType secuType; //보안매체구분

    @Enumerated(EnumType.STRING)
    private SecurityMediaStatus sccdScd; // 보안매체 상태코드

    private LocalDate isncYmd; // 발급년월일

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;      // 고객id(fk)


    @OneToMany(mappedBy = "token", fetch = LAZY, cascade = CascadeType.ALL)
    private List<Token> token;    // 토큰

    @OneToMany(mappedBy = "securityMedia") // 보안매체 이력
    private List<SecurityMediaHistory> securityMediaHistoryList = new ArrayList<>();


    @Builder
    public SecurityMedia(SecurityMediaType secuType, SecurityMediaStatus sccdScd, LocalDate isncYmd, LocalDateTime sysLsmdTs, Customer customer) {
        this.secuType = secuType;
        this.sccdScd = sccdScd;
        this.isncYmd = isncYmd;
        this.sysLsmdTs = sysLsmdTs;
        this.customer = customer;
    }

    public static SecurityMedia makeDigitalOtp(SecurityMediaType secuType, Customer customer) {
        SecurityMedia newSecurityMedia = SecurityMedia.builder()
                                            .secuType(secuType)
                                            .sccdScd(SecurityMediaStatus.REGISTER)
                                            .isncYmd(LocalDate.now())
                                            .sysLsmdTs(LocalDateTime.now())
                                            .customer(customer)
                                            .build();

        customer.getSecurityMedia().add(newSecurityMedia);

        return newSecurityMedia;
    }

    public void addToken() {

    }
}
