package com.example.demo.Customer;

import org.bson.types.ObjectId;
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

    @GetMapping(path = "{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") ObjectId id) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") ObjectId id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") ObjectId id,
                                                   @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }
}
