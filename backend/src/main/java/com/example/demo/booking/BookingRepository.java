package com.example.demo.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Override
    @Query("SELECT b FROM Booking b")
    List<Booking> findAll();
}
