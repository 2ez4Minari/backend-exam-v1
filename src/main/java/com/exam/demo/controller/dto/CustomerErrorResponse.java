package com.exam.demo.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerErrorResponse {

    private Integer transactionStatusCode;
    private String transactionStatusDescription;
}
