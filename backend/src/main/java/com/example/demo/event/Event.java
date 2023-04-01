package com.example.demo.event;

import com.example.demo.booking.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Event")
public class Event {
    @Id
    private Long eventID;
    private String eventTitle;
    private String eventDate;
    private String eventTime;
    @OneToMany(mappedBy = "event")
    private Set<Booking> booking;

}
