package com.example.demo.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, BookingID> {

    @Query("SELECT b " +
            "FROM Booking b " +
            "WHERE b.eventID = ?1 AND b.seatID = ?2")
    Optional<Booking> getBookingByBookingID(Integer eventID, String seatID);


    @Query("SELECT b FROM Booking b WHERE b NOT IN " +
            "(SELECT b from Booking b, PaymentBill pb " +
            "WHERE b.eventID = pb.eventID " +
            "AND b.customerID = pb.customerID " +
            "AND b.bookingDate = pb.billDate)")
    List<Booking> getBookingThatDoesNotHaveBill();

    @Query("SELECT b " +
            "FROM Booking b " +
            "WHERE b.eventID = ?1 AND b.customerID = ?2 " +
            "AND b.bookingDate = ?3")
    List<Booking> getBookingByEventIDAndCustomerIDAndBookingDate(Integer eventID, Integer customerID, Date bookingDate);

    @Query("SELECT sz.cost " +
            "FROM SeatZone sz, Seat s, Booking b " +
            "WHERE b.eventID = ?1 AND b.seatID = ?2 " +
            "AND b.seatID = s.seatID " +
            "AND s.zone = sz.zone")
    Integer getCostOfBooking(Integer eventID, String seatID);

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

//    @Modifying
//    @Transactional
//    @Query("INSERT INTO Booking b " +
//            "(b.eventID, b.seatID, b.customerID, b.bookingDate) " +
//            "VALUES (?1, ?2, ?3, ?4)")
//    void saveBooking(Integer eventID, String seatID, Integer customerID, Date bookingDate);
}
