package com.project.otp.bank.domain.customer.service;

import com.project.otp.bank.domain.customer.dto.CustomerInfo;

public interface CustomerService {

    public CustomerInfo findCustomerById(Long id);

    public CustomerInfo findOptionalCustomerByRnn(String rnn);
}
