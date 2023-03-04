package com.example.demo.Customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long index) {
        return customerRepository.findCustomerByIndex(index).
                orElseThrow(() -> new IllegalStateException("Customer with id " + index + " does not exist"));
    }

    public void addCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("This email has already been registered");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long index) {
        boolean exists = customerRepository.findCustomerByIndex(index).isPresent();
        if (!exists) {
            throw new IllegalStateException("" +
                    "Customer with id" + index + " does not exist");
        }
        customerRepository.deleteCustomerByIndex(index);

    }

    @Transactional
    public void updateCustomer(Long index, Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByIndex(index);

        if (customerOptional.isPresent()){
            Customer customer1 = customerOptional.get();
            customer1.setName(customer.getName());
            customer1.setEmail(customer.getEmail());
            customerRepository.save(customer1);
        } else {
            throw new IllegalStateException("Customer with id " + index + " does not exist");
        }
    }
}
