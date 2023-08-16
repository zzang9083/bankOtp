package com.project.otp.bank.infrastructure.customer;

import com.project.otp.bank.domain.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findOptionalCustomerByRnn(String rnn);
}
