package com.example.demo.seat;

import com.example.demo.booking.Booking;
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
    private Long SeatID;

    private String Zone;
    private boolean isBooked;

    @OneToOne
    private Booking booking;
}
