package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long index) {
        return customerRepository.findCustomerByIndex(index).
                orElseThrow(() -> new IllegalStateException("Customer with id " + index + " does not exist"));
    }
}
