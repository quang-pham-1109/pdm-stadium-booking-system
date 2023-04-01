package com.example.demo.booking;

import com.example.demo.event.Event;
import com.example.demo.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Booking")
@AllArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    private Long bookingID;
    private String bookingDate;

    @ManyToOne
    @JoinColumn(name = "eventID", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "customerID", nullable = false)
    private Customer customer;

    public Booking() {

    }
}
