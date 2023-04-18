package com.example.demo.seat;

import com.example.demo.booking.Booking;
import com.example.demo.event.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Entity
@Table(name = "Seat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @Column(name = "seat_id")
    private String seatID;
    private Boolean isBooked;
    private Integer price;

    @OneToOne(mappedBy = "seat")
    private Booking booking;
}
