package com.example.demo.event;

import com.example.demo.booking.Booking;
import com.example.demo.seat.Seat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "event_seq", allocationSize = 1)
    @Column(name = "event_id")
    private Integer eventID;

    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "event_time")
    private Time eventTime;

    @Column(name = "event_title")
    private String eventTitle;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    private List<Booking> booking;

}
