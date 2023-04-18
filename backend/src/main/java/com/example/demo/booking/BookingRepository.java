package com.example.demo.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b WHERE b.bookingDate = ?1")
    void setBookingDate(Date bookingDate);

    @Query("SELECT b FROM Booking b WHERE b.customerID = ?1")
    void setCustomerId(Integer customerId);

    @Override
    @Query("SELECT b FROM Booking b")
    List<Booking> findAll();



}
