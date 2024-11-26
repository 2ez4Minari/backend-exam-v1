package com.exam.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCustomerResponse {

    private Long customerNumber;
    private Integer transactionStatusCode;
    private String transactionStatusDescription;
}
