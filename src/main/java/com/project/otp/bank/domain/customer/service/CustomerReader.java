package com.project.otp.bank.domain.customer.service;

import com.project.otp.bank.domain.customer.model.Customer;

public interface CustomerReader {

    Customer findCustomerByRnn(String rnn);
}
