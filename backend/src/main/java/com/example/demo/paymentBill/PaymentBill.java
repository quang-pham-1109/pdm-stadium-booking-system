package com.example.demo.paymentBill;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="payment_bill")
public class PaymentBill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "bill_seq", allocationSize = 1)
    @Column(name = "bill_id")
    private Integer billID;

    @Column(name = "customer_id")
    private Integer customerID;

    @Column(name = "bill_date")
    private Date billDate;

    @Column(name = "total_cost")
    private Integer totalCost;
}
