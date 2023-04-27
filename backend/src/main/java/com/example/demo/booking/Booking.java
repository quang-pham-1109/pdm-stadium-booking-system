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
@IdClass(BookingID.class)
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @Column(name = "event_id", insertable=false, updatable=false)
    private Integer eventID;

    @Id
    @Column(name = "seat_id", insertable=false, updatable=false)
    private String seatID;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private Integer customerID;

    @Column(name = "booking_date")
    private Date bookingDate;


}
