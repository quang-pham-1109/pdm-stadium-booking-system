package com.example.demo.Customer;

import org.bson.types.ObjectId;
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

    public Customer getCustomerById(ObjectId id) {
        return customerRepository.findCustomerBy_id(id).
                orElseThrow(() -> new IllegalStateException("Customer with id " + id + " does not exist"));

    }

    public void addCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("This email has already been registered");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(ObjectId id) {
        boolean exists = customerRepository.findCustomerBy_id(id).isPresent();
        if (!exists) {
            throw new IllegalStateException("" +
                    "Customer with id" + id + " does not exist");
        }
        customerRepository.deleteCustomerBy_id(id);
    }

    @Transactional
    public void updateCustomer(ObjectId id, Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerBy_id(id);

        if (customerOptional.isPresent()){
            Customer customer1 = customerOptional.get();
            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            customer1.setEmail(customer.getEmail());
            customer1.setAddress(customer.getAddress());
            customer1.setPhoneNumber(customer.getPhoneNumber());
            customerRepository.save(customer1);
        } else {
            throw new IllegalStateException("Customer with id " + id + " does not exist");
        }
    }
}
