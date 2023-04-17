package com.example.demo.seat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatZoneService {
    public final SeatZoneRepository seatZoneRepository;

    public SeatZoneService(SeatZoneRepository seatZoneRepository) {
        this.seatZoneRepository = seatZoneRepository;
    }

    public List<SeatZone> getAllSeatZones() {
        return seatZoneRepository.findAll();
    }

    public SeatZone getSeatZoneByID(String seatZoneID) {
        return seatZoneRepository.findById(seatZoneID).
                orElseThrow(() -> new IllegalStateException("SeatZone does not exist"));
    }
}
