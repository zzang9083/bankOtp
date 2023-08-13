package com.project.otp.bank.infrastructure.repository;

import com.project.otp.bank.domain.model.bank.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //@EntityGraph(attributePaths = {"securityMedia"})
    Optional<Customer> findOptionalCustomerByRnn(String rnn);
}
