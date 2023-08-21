package com.project.otp.bank.domain.customer.service;

import com.project.otp.bank.domain.customer.dto.CustomerInfo;
import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.customer.repository.CustomerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerReader customerReader;

    @Override
    public CustomerInfo findCustomerById(Long id) {
        Customer customer = customerReader.findCustomerById(id);
        return new CustomerInfo(customer);
    }
    @Override
    @Transactional(readOnly = true)
    public CustomerInfo findOptionalCustomerByRnn(String rnn) {
        Customer customer = customerReader.findCustomerByRnn(rnn);
        return new CustomerInfo(customer);
    }


}
