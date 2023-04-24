package com.example.demo.seatZone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/{zone}/{price}")
    public ResponseEntity<SeatZone> updatePriceOfSeatZone(
            @PathVariable("zone") String zone,
            @PathVariable("price") Integer price) {
        seatZoneService.updatePriceOfSeatZone(zone, price);
        return new ResponseEntity<>(HttpStatus.OK);    }
}
