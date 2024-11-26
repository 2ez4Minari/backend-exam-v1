package com.exam.demo.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetCustomerResponse {

    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<CustomerAccount> savings;
    
    private Long customerNumber;
    private Integer transactionStatusCode;
    private String transactionStatusDescription;
}
