package com.example.demo.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Booking b SET b.bookingDate = ?2 WHERE b.bookingID = ?1")
    void setBookingDate(Integer bookingID, Date bookingDate);

    @Modifying
    @Transactional
    @Query("UPDATE Booking b SET b.eventID = ?2 WHERE b.bookingID = ?1")
    void setEventId(Integer bookingID, Integer eventID);

    @Modifying
    @Transactional
    @Query("UPDATE Booking b SET b.seatID = ?2 WHERE b.bookingID = ?1")
    void setSeatId(Integer bookingID, String seatID);

    @Modifying
    @Transactional
    @Query("UPDATE Booking b SET b.customerID = ?2 WHERE b.bookingID = ?1")
    void setCustomerId(Integer bookingID, Integer customerId);

    @Query("SELECT b.seatID FROM Booking b WHERE b.eventID = ?1")
    List<String> findAllByEventID(String eventID);

    @Query("SELECT sz.cost " +
            "FROM SeatZone sz, Seat s, Booking b " +
            "WHERE b.bookingID = ?1 " +
            "AND b.seatID = s.seatID " +
            "AND s.zone = sz.zone")
    Integer findCostOfBooking(Integer bookingID);

    @Query("SELECT b FROM Booking b WHERE b.bookingID = ?1")
    Optional<Booking> getBookingByBookingID(Integer bookingID);

    @Query("SELECT b FROM Booking b WHERE b.customerID = ?1")
    List<Booking> getBookingsByCustomerID(Integer customerID);

    @Modifying
    @Transactional
    @Query("DELETE FROM Booking b " +
            "WHERE b.bookingID = ?1 " +
            "AND b.customerID = ?2")
    void deleteBooking(Integer bookingID, Integer customerID);
}
