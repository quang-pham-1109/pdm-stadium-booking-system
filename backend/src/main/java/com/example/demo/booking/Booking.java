package com.example.demo.booking;

import com.example.demo.event.Event;
import com.example.demo.customer.Customer;
import com.example.demo.seat.Seat;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
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

    @OneToOne
    @JoinColumn(name = "SeatID", nullable = false)
    private Seat seat;

}
