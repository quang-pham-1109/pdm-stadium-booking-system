package com.example.demo.seat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seatzone")
public class SeatZoneController {
    public final SeatZoneService seatZoneService;

    public SeatZoneController(SeatZoneService seatZoneService) {
        this.seatZoneService = seatZoneService;
    }

    @GetMapping
    public List<SeatZone> getSeatZones() {
        return seatZoneService.getAllSeatZones();
    }

    @GetMapping(path = "/{seatZoneID}")
    public SeatZone getSeatZoneByID(@PathVariable("seatZoneID") String seatZoneID) {
        return seatZoneService.getSeatZoneByID(seatZoneID);
    }
}
