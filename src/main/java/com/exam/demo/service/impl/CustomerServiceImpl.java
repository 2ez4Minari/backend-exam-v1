package com.exam.demo.service.impl;

import com.exam.demo.controller.dto.CreateCustomerResponse;
import com.exam.demo.controller.dto.CustomerAccount;
import com.exam.demo.controller.dto.GetCustomerResponse;
import com.exam.demo.controller.exception.InvalidRequestException;
import com.exam.demo.controller.exception.NotFoundException;
import com.exam.demo.repository.*;
import com.exam.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public ResponseEntity createCustomer(Customer customer) throws InvalidRequestException {

        if(customer.getCustomerEmail().isEmpty()) {

            throw new InvalidRequestException("Email is a required field");
        }

        String accountType = (customer.getAccountType().equals(AccountType.S)) ? "Savings" : "Checking";
        customer.setSavings(Arrays.asList(
                Account.builder()
                        .availableBalance(BigDecimal.valueOf(500))
                        .accountType(accountType)
                        .customer(customer)
                        .build()
        ));

        Customer createdCustomer = customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                        CreateCustomerResponse.builder()
                        .customerNumber(createdCustomer.getCustomerId())
                        .transactionStatusCode(HttpStatus.CREATED.value())
                        .transactionStatusDescription("Customer account created")
                        .build()
        );
    }

    @Override
    public ResponseEntity<?> getCustomer(Long customerNumber) throws NotFoundException {
        Optional<Customer> existingCustomer = customerRepository.findByCustomerId(customerNumber);

        if(!existingCustomer.isPresent()) {
            throw new NotFoundException("Customer not found");
        }


        return ResponseEntity.status(HttpStatus.FOUND).body(getCustomerResponseMapper(existingCustomer.get()));
    }

    private GetCustomerResponse getCustomerResponseMapper(Customer customer) {
        List<CustomerAccount> accounts = new ArrayList<>();
        customer.getSavings().forEach(account -> accounts.add(
                CustomerAccount.builder()
                        .accountId(account.getAccountId())
                        .availableBalance(account.getAvailableBalance())
                        .accountType(account.getAccountType())
                        .build()
        ));

        return GetCustomerResponse.builder()
                .customerNumber(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerMobile(customer.getCustomerMobile())
                .customerEmail(customer.getCustomerEmail())
                .address1(customer.getAddress1())
                .address2(customer.getAddress2())
                .savings(accounts)
                .transactionStatusCode(HttpStatus.FOUND.value())
                .transactionStatusDescription("Customer Account found")
                .build();
    }
}
