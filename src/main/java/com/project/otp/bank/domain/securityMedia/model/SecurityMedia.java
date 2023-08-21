package com.project.otp.bank.domain.securityMedia.model;

import com.project.otp.bank.domain.customer.model.Customer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private LocalDate expyYmd; // 만료년월일

    private LocalDateTime sysLsmdTs; // 최종변경시간

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;      // 고객id(fk)


    @OneToMany(mappedBy = "securityMedia", fetch = LAZY)
    private List<Token> token = new ArrayList<>();    // 토큰

    @OneToMany(mappedBy = "securityMedia") // 보안매체 이력
    private List<SecurityMediaHistory> securityMediaHistoryList = new ArrayList<>();


    @Builder
    public SecurityMedia(SecurityMediaType secuType, SecurityMediaStatus sccdScd, LocalDate isncYmd, LocalDate expyYmd, LocalDateTime sysLsmdTs, Customer customer) {
        this.secuType = secuType;
        this.sccdScd = sccdScd;
        this.isncYmd = isncYmd;
        this.expyYmd = expyYmd;
        this.sysLsmdTs = sysLsmdTs;
        this.customer = customer;
    }

    public static SecurityMedia issueDigitalOtp(SecurityMediaType secuType, Customer customer) {
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

    public void addToken(Token newToken) {
        token.add(newToken);
        newToken.setSecurityMedia(this);
    }

    public Token getActiveToken() {
        List<Token> activateToken;
        if(token == null) {
            throw new RuntimeException("발급된 토큰이 없습니다.");
        }
        else {
            activateToken = token.stream()
                    .filter(s -> s.getTokenStatus() == TokenStatus.ACTIVATE)
                    .limit(1).collect(Collectors.toList());
            if(activateToken.isEmpty()) {
                throw new RuntimeException("발급된 토큰이 없습니다.");
            }
        }
        return activateToken.get(0);
    }
}
