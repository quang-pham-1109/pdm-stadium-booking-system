package Event;

import com.example.demo.Booking.Booking;
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
