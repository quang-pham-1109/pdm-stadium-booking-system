package com.example.demo.seat;

import org.springframework.stereotype.Service;

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

    public Seat getSeatByID(String seatID) {
        return seatRepository.findById(seatID).
                orElseThrow(() -> new IllegalStateException("Seat does not exist"));
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

}
