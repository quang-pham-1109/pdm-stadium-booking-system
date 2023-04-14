package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer){
        Optional<Customer> customerOptional = customerRepository.
                findByEmail(customer.getEmail());
        if(customerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer customerId){
        return customerRepository.findCustomerByCustomerId(customerId).
                orElseThrow(() -> new IllegalStateException("Customer does not exist"));
    }

    public void deleteCustomer(Integer customerId){
        boolean exists = customerRepository.existsById(customerId);
        if (!exists){
            throw new IllegalStateException(
                    "customer with id " + customerId + "does not exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public void updateCustomer(Integer customerId, Customer customer){
        Customer customer1 = customerRepository.findCustomerByCustomerId(customerId).
                orElseThrow(() -> new IllegalStateException("Customer does not exist"));
        if(customer.getFirstName() != null && customer.getFirstName().length() > 0 &&
                !Objects.equals(customer1.getFirstName(), customer.getFirstName())){
            customer1.setFirstName(customer.getFirstName());
        }
        if(customer.getLastName() != null && customer.getLastName().length() > 0 &&
                !Objects.equals(customer1.getLastName(), customer.getLastName())){
            customer1.setLastName(customer.getLastName());
        }
        if(customer.getDateOfBirth() != null && customer.getDateOfBirth().length() > 0 &&
                !Objects.equals(customer1.getDateOfBirth(), customer.getDateOfBirth())){
            customer1.setDateOfBirth(customer.getDateOfBirth());
        }
        if(customer.getPhoneNumber() != null && customer.getPhoneNumber().length() > 0 &&
                !Objects.equals(customer1.getPhoneNumber(), customer.getPhoneNumber())){
            customer1.setPhoneNumber(customer.getPhoneNumber());
        }
        if(customer.getEmail() != null && customer.getEmail().length() > 0 &&
                !Objects.equals(customer1.getEmail(), customer.getEmail())){
            Optional<Customer> customerOptional = customerRepository.
                    findByEmail(customer.getEmail());
            if(customerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            customer1.setEmail(customer.getEmail());
        }
        if(customer.getAddress() != null && customer.getAddress().length() > 0 &&
                !Objects.equals(customer1.getAddress(), customer.getAddress())){
            customer1.setAddress(customer.getAddress());
        }
    }
}
