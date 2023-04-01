package com.example.demo.paymentBill;

import com.example.demo.booking.Booking;
import com.example.demo.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PaymentBill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentBill {
    @Id
    private Long PaymentID;

    private Long paymentAmount;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "bookingID", nullable = false)
    private Booking booking;


}
