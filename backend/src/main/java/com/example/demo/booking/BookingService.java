package com.example.demo.booking;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    public final BookingInterface bookingInterface;

    public BookingService(BookingInterface bookingInterface) {
        this.bookingInterface = bookingInterface;
    }

    public Booking createBooking(Booking booking) {
        return bookingInterface.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingInterface.findAll();
    }

    public Booking getBookingByID(Integer bookingID) {
        return bookingInterface.findById(bookingID).
                orElseThrow(() -> new IllegalStateException("Booking does not exist"));
    }
}
