package com.example.demo.booking;

import com.example.demo.customer.CustomerRepository;
import com.example.demo.event.EventRepository;
import com.example.demo.seat.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    public final BookingRepository bookingRepository;
    public final SeatRepository seatRepository;
    public final CustomerRepository customerRepository;
    public final EventRepository eventRepository;

    public BookingService(BookingRepository bookingRepository,
                          SeatRepository seatRepository,
                          CustomerRepository customerRepository,
                          EventRepository eventRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
        this.customerRepository = customerRepository;
        this.eventRepository = eventRepository;
    }

    public Booking createBooking(Booking booking, Integer customerID) {
        if (eventRepository.findAvailableSeatsByEventID(booking.getEventID()).get() == 0) {
            throw new IllegalStateException("No available seats");
        }
        eventRepository.findEventByEventID(booking.getEventID()).
                orElseThrow(() -> new IllegalStateException("Event does not exist")); //check if event exists
        booking.setCustomer(customerRepository.findById(customerID).
                orElseThrow(() -> new IllegalStateException("Customer does not exist"))); //check if customer exists

        eventRepository.decreaseAvailableSeatsByEventID(booking.getEventID()); //decrease available seats by 1
        booking.setBookingDate(new Date());
        booking.setCustomerID(customerID);
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
