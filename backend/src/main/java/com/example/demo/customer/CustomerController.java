package com.example.demo.customer;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return new  ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Integer customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Integer customerId,
                                                   @RequestBody Customer customer){
        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
