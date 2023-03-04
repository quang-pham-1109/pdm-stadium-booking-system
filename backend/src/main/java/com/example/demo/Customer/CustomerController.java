package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "/{index}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("index") Long index) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(index), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{index}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("index") Long index) {
        customerService.deleteCustomer(index);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }

    @PutMapping(path = "{index}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("index") Long index,
                                                   @RequestBody Customer customer){
        customerService.updateCustomer(index, customer);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }

}
