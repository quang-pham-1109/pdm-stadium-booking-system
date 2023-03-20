package com.example.demo.Booking;

import com.example.demo.Customer.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {
    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;
    @Id
    private Long bookingID;
    private String bookingDate;
    public Booking() {

    }

}
