package com.example.demo.Customer;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
    Optional<Customer> findCustomerBy_id(ObjectId id);
    Optional<Customer> findCustomerByEmail(String email);
    Optional<Customer> deleteCustomerBy_id (ObjectId id);
}
