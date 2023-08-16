package com.project.otp.bank.domain.customer.dto;

import com.project.otp.bank.domain.customer.model.Account;
import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.external.model.ExternalTrnInfo;
import com.project.otp.bank.domain.securityMedia.model.SecurityMedia;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Getter
public class CustomerInfo {

    private Long custId;       // 고객 아이디

    private String custName;    // 고객명

    private char indvCorpDtlDcd; // 개인법인상세구분코드

    private String rnn; // 실명번호(사업자번호)

    private LocalDate birtYmd; // 생년월일

    private String cpn;     // 핸드폰번호

    private String custScd ; // 이용자상태

    private LocalDateTime frrgTs; // 최초등록시간

    private LocalDateTime sysLsmdTs; // 최종변경시간

    private List<SecurityMedia> securityMedia;    // 보안매체

    private List<Account> accountList;  // 계좌목록

    private List<ExternalTrnInfo> externalTrnInfoList ;  // 대외거래 목록

    public CustomerInfo(Customer customer) {
        this.custId = customer.getCustId();
        this.custName = customer.getCustName();
        this.indvCorpDtlDcd = customer.getIndvCorpDtlDcd();
        this.rnn = customer.getRnn();
        this.birtYmd = customer.getBirtYmd();
        this.cpn = customer.getCpn();
        this.custScd = customer.getCustScd();
        this.frrgTs = customer.getFrrgTs();
        this.sysLsmdTs = customer.getFrrgTs();
        this.securityMedia = customer.getSecurityMedia();
        this.accountList = customer.getAccountList();
        this.externalTrnInfoList = customer.getExternalTrnInfoList();
    }
}
