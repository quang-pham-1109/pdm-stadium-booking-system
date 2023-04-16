package com.example.demo.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends
        JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> findCustomerByCustomerId(Integer customerId);
}
