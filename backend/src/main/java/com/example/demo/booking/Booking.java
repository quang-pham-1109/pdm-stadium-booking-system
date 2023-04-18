package com.example.demo.booking;

import com.example.demo.customer.Customer;
import com.example.demo.event.Event;
import com.example.demo.seat.Seat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "booking_seq", allocationSize = 1)
    @Column(name = "booking_id")
    private Integer bookingID;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private Integer customerID;

    @Column(name = "event_id", insertable=false, updatable=false)
    private Integer eventID;

    @Column(name = "seat_id", insertable=false, updatable=false)
    private String seatID;

    @Column(name = "booking_date")
    private Date bookingDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

}
