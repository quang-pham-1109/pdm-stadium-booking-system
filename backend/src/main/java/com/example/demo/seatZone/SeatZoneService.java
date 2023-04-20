package com.example.demo.seatZone;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatZoneService {
    public final SeatZoneRepository seatZoneRepository;

    public SeatZoneService(SeatZoneRepository seatZoneRepository) {
        this.seatZoneRepository = seatZoneRepository;
    }

    public List<SeatZone> getAllSeatZone() {
        return seatZoneRepository.findAll();
    }
}
