package com.example.demo.booking;

import com.example.demo.paymentBill.PaymentBillService;
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

    @GetMapping(path = "/get-booking")
    public ResponseEntity<Booking> getBookingByID(
            @RequestParam Integer eventID,
            @RequestParam String seatID) {
        return new ResponseEntity<>(
                bookingService.getBookingByID(eventID, seatID),
                HttpStatus.OK);
    }

    @GetMapping(path = "/get-price-of-booking")
    public ResponseEntity<Integer> checkPrice(
            @RequestParam Integer eventID,
            @RequestParam String seatID) {
        return new ResponseEntity<>(
                bookingService.getCostOfABooking(eventID, seatID),
                HttpStatus.OK);
    }

    @GetMapping(path = "/get-by-customer-id")
    public ResponseEntity<List<Booking>> getBookingsByCustomerID(
            @RequestParam Integer customerID) {
        return new ResponseEntity<>(
                bookingService.getBookingsByCustomerID(customerID),
                HttpStatus.OK);
    }

    @PostMapping(path = "/create-booking")
    public ResponseEntity<Booking> createBooking(
            @RequestParam Integer customerID,
            @RequestBody Booking booking) {
        return new ResponseEntity<>(
                bookingService.createBooking(booking, customerID),
                HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete-booking")
    public ResponseEntity<Booking> deleteBooking(
            @RequestParam Integer customerID,
            @RequestParam Integer eventID,
            @RequestParam String seatID) {
        bookingService.deleteBooking(eventID, seatID, customerID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
