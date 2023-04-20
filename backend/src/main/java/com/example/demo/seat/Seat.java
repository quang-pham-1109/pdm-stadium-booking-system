package com.example.demo.seat;

import com.example.demo.booking.Booking;
import com.example.demo.event.Event;
import com.example.demo.seatZone.SeatZone;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.util.List;

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

    @Column(name = "zone", insertable=false, updatable=false)
    private String zone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
    private List<Booking> booking;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone")
    private SeatZone seatZone;
}
