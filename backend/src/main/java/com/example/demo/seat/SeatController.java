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

    @GetMapping(path = "booked/{eventID}")
    public ResponseEntity<List<String>> getSeatsByEventID(@PathVariable("eventID")
                                                            Integer eventID) {
        return ResponseEntity.ok(seatService.getAllBookedSeatByEventID(eventID));
    }

    @GetMapping(path = "available/{eventID}")
    public ResponseEntity<List<String>> getAvailableSeatsByEventID(@PathVariable("eventID")
                                                            Integer eventID) {
        return ResponseEntity.ok(seatService.getAllAvailableSeatsByEventID(eventID));
    }
}
