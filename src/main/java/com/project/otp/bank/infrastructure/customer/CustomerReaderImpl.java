package com.project.otp.bank.infrastructure.customer;

import com.project.otp.bank.domain.customer.model.Customer;
import com.project.otp.bank.domain.customer.service.CustomerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerReaderImpl implements CustomerReader {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findCustomerByRnn(String rnn) {
        return customerRepository.findOptionalCustomerByRnn(rnn)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자"));
    }
}
