package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends
        JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.customerId = ?1")
    Optional<Customer> findCustomerByCustomerId(Integer customerId);

}
