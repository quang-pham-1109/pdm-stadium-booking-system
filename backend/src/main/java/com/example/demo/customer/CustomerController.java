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
        return new  ResponseEntity<List<Customer>>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId,
                                                   @RequestBody Customer customer){
        customerService.updateCustomer(customerId, customer);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }
}
