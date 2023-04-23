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
                findCustomerByEmail(customer.getEmail());
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
    public void updateCustomer(Integer customerId,
                               Customer customer){
        Customer editedCustomer = customerRepository.findById(customerId).
                orElseThrow(() -> new IllegalStateException(
                        "customer with id " + customerId + "does not exist"));
        //Check and edit first name
        if (customer.getFirstName() != null &&
                customer.getFirstName().length() > 0 &&
                !Objects.equals(editedCustomer.getFirstName(), customer.getFirstName())){
            editedCustomer.setFirstName(customer.getFirstName());
        }
        //Check and edit last name
        if (customer.getLastName() != null &&
                customer.getLastName().length() > 0 &&
                !Objects.equals(editedCustomer.getLastName(), customer.getLastName())){
            editedCustomer.setLastName(customer.getLastName());
        }
        //Check and edit email address
        if (customer.getEmail() != null &&
                customer.getEmail().length() > 0 &&
                !Objects.equals(editedCustomer.getEmail(), customer.getEmail())){
            Optional<Customer> customerOptional = customerRepository.
                    findCustomerByEmail(customer.getEmail());
            if(customerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            editedCustomer.setEmail(customer.getEmail());
        }
        //Check and edit date of birth
        if (customer.getDateOfBirth() != null &&
                !Objects.equals(editedCustomer.getDateOfBirth(), customer.getDateOfBirth())) {
            editedCustomer.setDateOfBirth(customer.getDateOfBirth());
        }
        //Check and edit address
        if (customer.getAddress() != null &&
                customer.getAddress().length() > 0 &&
                !Objects.equals(editedCustomer.getAddress(), customer.getAddress())){
            editedCustomer.setAddress(customer.getAddress());
        }
        //Check and edit phone number
        if (customer.getPhoneNumber() != null &&
                customer.getPhoneNumber().length() > 0 &&
                !Objects.equals(editedCustomer.getPhoneNumber(), customer.getPhoneNumber())){
            editedCustomer.setPhoneNumber(customer.getPhoneNumber());
        }
    }
}
