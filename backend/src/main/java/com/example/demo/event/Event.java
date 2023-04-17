package com.example.demo.event;

import com.example.demo.booking.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
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

    @Column(name = "event_title")
    private String eventTitle;

    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "event_time")
    private Time eventTime;

    @OneToMany(mappedBy = "event")
    private Set<Booking> booking;

}
