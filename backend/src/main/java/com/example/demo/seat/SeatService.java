package com.example.demo.seat;

import com.example.demo.booking.BookingRepository;
import com.example.demo.event.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {
    public final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public List<String> getAllBookedSeatByEventID(Integer eventID) {
        return seatRepository.findAllBookedSeatsByEvent(eventID);
    }

    public List<String> getAllAvailableSeatsByEventID(Integer eventID) {
        return seatRepository.findAllAvailableSeatsByEventID(eventID);
    }

    public Integer getSeatCost(String seatID) {
        return seatRepository.findCostOfSeatBySeatID(seatID);
    }
}
