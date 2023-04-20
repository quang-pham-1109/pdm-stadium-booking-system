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
        //Check if seat is available
        if (seatRepository.findAllAvailableSeatsByEventID(
                booking.getEventID()).size() == 0) {
            throw new IllegalStateException("No available seats");
        }

        //Check if seat is booked
        if (seatRepository.findAllBookedSeatsByEvent(
                booking.getEventID()).
                contains(booking.getSeatID())) {
            throw new IllegalStateException("Seat is already booked");
        }

        //Check if event exists
        eventRepository.findEventByEventID(booking.getEventID()).
                orElseThrow(() -> new IllegalStateException("Event does not exist"));

        //Check if customer exists
        booking.setCustomer(customerRepository.findById(customerID).
                orElseThrow(() -> new IllegalStateException("Customer does not exist")));

        //Decrease seat amounts of event
        eventRepository.decreaseAvailableSeatsByEventID(booking.getEventID());

        var newBooking = Booking.builder()
                .bookingDate(new Date())
                .event(eventRepository.findEventByEventID(booking.getEventID()).get())
                .seat(seatRepository.findSeatBySeatID(booking.getSeatID()).get())
                .customer(customerRepository.findById(customerID).get())
                .build();

        return bookingRepository.save(newBooking);
    }
    public Integer checkCost(Integer bookingID) {
        bookingRepository.getBookingByBookingID(bookingID).
                orElseThrow(() -> new IllegalStateException("Booking does not exist"));
        return bookingRepository.findCostOfBooking(bookingID);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingByID(Integer bookingID) {
        return bookingRepository.findById(bookingID).
                orElseThrow(() -> new IllegalStateException("Booking does not exist"));
    }
}
