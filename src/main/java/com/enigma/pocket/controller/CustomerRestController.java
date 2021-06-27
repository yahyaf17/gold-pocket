package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.CustomerLoginDto;
import com.enigma.pocket.repository.CustomerRepository;
import com.enigma.pocket.service.CustomerService;
import com.enigma.pocket.wrapper.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RequestMapping(value = "/api")
@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

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

    @PutMapping("/customer/login")
    public Customer loginUser(@Valid @RequestBody CustomerLoginDto request) {
        Customer toCustomer = customerRepository.findByUsername(request.getUsername());
        System.out.println(toCustomer);
        if (toCustomer.getPassword().equals(request.getPassword())) {
            System.out.println(toCustomer.getPassword().equals(request.getPassword()));
            toCustomer.setLoggedIn(true);
            return customerRepository.save(toCustomer);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Password anda salah atau belum terdaftar"));
        }

    }

    @PutMapping ("/customer/{id}/logout")
    public Customer logUserOut(@Valid @PathVariable(name = "id") String id) {
        Customer customer = customerService.findCustomerById(id);
        customer.setLoggedIn(false);
        return customerRepository.save(customer);
    }

}
