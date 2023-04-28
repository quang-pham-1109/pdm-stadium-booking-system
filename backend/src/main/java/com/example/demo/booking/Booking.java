package com.example.demo.booking;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BookingID.class)
@DynamicInsert
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @Column(name = "event_id")
    private Integer eventID;

    @Id
    @Column(name = "seat_id")
    private String seatID;

    @Column(name = "customer_id")
    private Integer customerID;

    @Column(name = "booking_date")
    private Date bookingDate;

}
