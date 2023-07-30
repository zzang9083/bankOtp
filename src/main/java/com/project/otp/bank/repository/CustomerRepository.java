package com.project.otp.bank.repository;

import com.project.otp.bank.domain.bank.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findOptionalCustomerByRnn(String rnn);
}
