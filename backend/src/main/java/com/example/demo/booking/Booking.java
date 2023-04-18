package com.example.demo.booking;

import com.example.demo.customer.Customer;
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

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "event_id")
    private Integer eventID;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private Integer customerID;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "seat_id")
    private String seatID;

}
