package com.example.demo.seat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seat")
public class SeatController {

    public final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    @GetMapping(path = "/{seatID}")
    public ResponseEntity<Seat> getSeatByID(@PathVariable("seatID") String seatID) {
        return ResponseEntity.ok(seatService.getSeatByID(seatID));
    }

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        return ResponseEntity.ok(seatService.createSeat(seat));
    }
}
