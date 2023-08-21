package com.project.otp.bank.domain.customer.repository;

import com.project.otp.bank.domain.customer.model.Customer;

public interface CustomerReader {

    Customer findCustomerById(Long custId);

    Customer findCustomerByRnn(String rnn);


}
