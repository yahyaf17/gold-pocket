package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.service.CustomerService;
import com.enigma.pocket.wrapper.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") String id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers")
    public PageWrapper<Customer> getAllCustomer(@RequestParam (name = "page", defaultValue = "0") Integer page,
                                                @RequestParam (name = "size", defaultValue = "5") Integer size,
                                                @RequestParam (name = "sort", defaultValue = "firstName") String sortBy,
                                                @RequestParam (name = "direction", defaultValue = "ASC") Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction,sortBy));
        Page<Customer> customerPage = customerService.findCustomers(pageable);
        return new PageWrapper<Customer>(customerPage);
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable(name = "id") String id) {
        customerService.removeCustomer(id);
    }

    @PutMapping("/customer")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }
}
