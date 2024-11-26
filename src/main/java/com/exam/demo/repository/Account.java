package com.exam.demo.repository;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long accountId;

    private String accountType;
    private BigDecimal availableBalance;

    @ManyToOne
    @JoinColumn(name="customerNumber")
    private Customer customer;
}
