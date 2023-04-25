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
        return new ResponseEntity<>(
                bookingService.getAllBookings(),
                HttpStatus.OK);
    }

    @GetMapping(path = "/{bookingID}")
    public ResponseEntity<Booking> getBookingByID(
            @PathVariable("bookingID")
            Integer bookingID) {
        return new ResponseEntity<>(
                bookingService.getBookingByID(bookingID),
                HttpStatus.OK);
    }

    @GetMapping(path = "/check-cost/{booking-id}")
    public ResponseEntity<Integer> checkPrice(
            @PathVariable("booking-id")
            Integer bookingID) {
        return new ResponseEntity<>(
                bookingService.checkCost(bookingID),
                HttpStatus.OK);
    }

    @GetMapping(path = "/customer/{customerID}")
    public ResponseEntity<List<Booking>> getBookingsByCustomerID(
            @PathVariable("customerID")
            Integer customerID) {
        return new ResponseEntity<>(
                bookingService.getBookingsByCustomerID(customerID),
                HttpStatus.OK);
    }

    @PostMapping(path = "/{customerID}")
    public ResponseEntity<Booking> createBooking(
            @PathVariable("customerID") Integer customerID,
            @RequestBody Booking booking) {
        return new ResponseEntity<>(
                bookingService.createBooking(booking, customerID),
                HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{bookingID}/{customerID}")
    public ResponseEntity<Booking> deleteBooking(
            @PathVariable("bookingID")
            Integer bookingID,
            @PathVariable("customerID")
            Integer customerID) {
        bookingService.deleteBooking(bookingID, customerID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{bookingID}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable("bookingID")
            Integer bookingID,
            @RequestBody Booking booking) {
        bookingService.updateBooking(bookingID, booking);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
