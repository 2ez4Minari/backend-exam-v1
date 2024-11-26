package com.exam.demo.service;

import com.exam.demo.controller.exception.InvalidRequestException;
import com.exam.demo.repository.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> createCustomer(Customer customer) throws InvalidRequestException;
    ResponseEntity<?> getCustomer(Long customerNumber);
}
