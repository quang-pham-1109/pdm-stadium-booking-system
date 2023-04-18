package com.example.demo.seat;

import com.example.demo.booking.BookingRepository;
import com.example.demo.event.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {
    public final SeatRepository seatRepository;
    public final EventRepository eventRepository;
    public final BookingRepository bookingRepository;

    public SeatService(SeatRepository seatRepository, EventRepository eventRepository, BookingRepository bookingRepository) {
        this.seatRepository = seatRepository;
        this.eventRepository = eventRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatByID(String seatID) {
        return seatRepository.findById(seatID).
                orElseThrow(() -> new IllegalStateException("Seat does not exist"));
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<String> getAllBookedSeatByEventID(String eventID) {
        return seatRepository.findAllBookedSeatsByEvent(eventID);
    }

    public List<String> getAllAvailableSeatsByEventID(String eventID) {
        return seatRepository.findAllAvailableSeatsByEventID(eventID);
    }
}
