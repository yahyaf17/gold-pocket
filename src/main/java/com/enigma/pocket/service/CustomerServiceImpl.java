package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final String notFoundMessage = "Customer with id: %s Not Found!";

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(String id) {
        validateCustomer(id);
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> findCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void createCustomer(Customer customer) {
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        validateCustomer(customer.getId());
        customer.setUpdatedAt(new Date());
        customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(String id) {
        validateCustomer(id);
        customerRepository.deleteById(id);
    }

    @Override
    public void validateCustomer(String id) {
        if(!(customerRepository.findById(id).isPresent())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
