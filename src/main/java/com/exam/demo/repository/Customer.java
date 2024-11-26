package com.exam.demo.repository;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long customerId;

    private String customerName;
    private String customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;

    @Transient
    private AccountType accountType;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> savings;
}