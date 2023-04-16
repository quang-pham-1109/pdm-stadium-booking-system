package com.example.demo.seat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seat_zone")
public class SeatZone {
    @Id
    @Column(name = "zone")
    private String Zone;

    @Column(name = "cost")
    private Integer Cost;
}
