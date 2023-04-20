package com.example.demo.seatZone;

import com.example.demo.seat.Seat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seat-zone")
public class SeatZoneController {
    public final SeatZoneService seatZoneService;

    public SeatZoneController(SeatZoneService seatZoneService) {
        this.seatZoneService = seatZoneService;
    }

    @GetMapping
    public ResponseEntity<List<SeatZone>> getSeatZone() {
        return ResponseEntity.ok(seatZoneService.getAllSeatZone());
    }
}
