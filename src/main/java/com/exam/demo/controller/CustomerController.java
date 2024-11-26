package com.exam.demo.controller;

import com.exam.demo.repository.Customer;
import com.exam.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/account")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

        return customerService.createCustomer(customer);
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerNumber) {
        
        return customerService.getCustomer(customerNumber);
    }
}
