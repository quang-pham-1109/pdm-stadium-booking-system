package com.example.demo.seatZone;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void updatePriceOfSeatZone(String zone, Integer price) {
        seatZoneRepository.findById(zone).ifPresent(seatZone -> {
            seatZone.setCost(price);
            seatZoneRepository.save(seatZone);
        });
    }
}
