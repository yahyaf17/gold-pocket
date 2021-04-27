package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {

    Customer findCustomerById(String id);
    Page<Customer> findCustomers(Pageable pageable);
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void removeCustomer(String id);
    void validateCustomer(String id);

}
