package com.example.demo.seat;

import com.example.demo.booking.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Entity
@Table(name = "Seat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Seat {
    @Id
    private Long SeatID;

    private String Zone;
    private boolean isBooked;

    @OneToOne
    private Booking booking;
}
