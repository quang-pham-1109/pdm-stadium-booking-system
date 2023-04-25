package com.example.demo.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b " +
            "FROM Booking b " +
            "WHERE b.eventID = ?1 AND b.seatID = ?2")
    Optional<Booking> getBookingByBookingID(Integer eventID, String seatID);

    @Query("SELECT sz.cost " +
            "FROM SeatZone sz, Seat s, Booking b " +
            "WHERE b.eventID = ?1 AND b.seatID = ?2 " +
            "AND b.seatID = s.seatID " +
            "AND s.zone = sz.zone")
    Integer findCostOfBooking(Integer eventID, String seatID);

    @Query("SELECT b " +
            "FROM Booking b " +
            "WHERE b.customerID = ?1")
    List<Booking> getBookingsByCustomerID(Integer customerID);

    @Modifying
    @Transactional
    @Query("DELETE FROM Booking b " +
            "WHERE b.eventID = ?1 AND b.seatID = ?2 " +
            "AND b.customerID = ?3")
    void deleteBooking(Integer eventID, String seatID, Integer customerID);
}
