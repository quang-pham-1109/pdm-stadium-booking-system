package com.example.demo.seatZone;

import com.example.demo.seat.Seat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seat_zone")
public class SeatZone {
    @Id
    private String zone;

    @Column(name = "cost")
    private Integer cost;

}



