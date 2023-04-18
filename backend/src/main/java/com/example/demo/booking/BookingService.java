package com.example.demo.booking;

import com.example.demo.customer.CustomerRepository;
import com.example.demo.seat.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    public final BookingRepository bookingRepository;
    public final SeatRepository seatRepository;
    public final CustomerRepository customerRepository;

    public BookingService(BookingRepository bookingRepository,
                          SeatRepository seatRepository,
                          CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
        this.customerRepository = customerRepository;
    }

    public Booking createBooking(Booking booking, Integer customerID) {
        seatRepository.bookSeat(booking.getSeatID());
        bookingRepository.setBookingDate(new Date());
        booking.setCustomer(customerRepository.findById(customerID).
                orElseThrow(() -> new IllegalStateException("Customer does not exist")));
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingByID(Integer bookingID) {
        return bookingRepository.findById(bookingID).
                orElseThrow(() -> new IllegalStateException("Booking does not exist"));
    }
}
