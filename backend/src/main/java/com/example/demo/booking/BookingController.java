package com.example.demo.booking;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/booking")
public class BookingController {
    public final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getBookings() {
        return new ResponseEntity<List<Booking>>(
                bookingService.getAllBookings(),
                HttpStatus.OK);
    }

    @GetMapping(path = "/{bookingID}")
    public ResponseEntity<Booking> getBookingByID(@PathVariable("bookingID") Integer bookingID) {
        return new ResponseEntity<Booking>(
                bookingService.getBookingByID(bookingID),
                HttpStatus.OK);
    }

//    @PostMapping(path = "/{customerID}")
//    public ResponseEntity<Booking> createBooking(
//            @PathVariable("customerID") Integer customerID,
//            @RequestBody Booking booking) {
//        return new ResponseEntity<Booking>(
//                bookingService.createBooking(booking, customerID),
//                HttpStatus.CREATED);
//    }

}
