package com.example.demo.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {

    @Query("SELECT s.seatID " +
            "FROM Seat s " +
            "WHERE s.seatID NOT IN " +
            "(SELECT b.seatID " +
            "FROM Booking b " +
            "WHERE b.eventID = ?1)")
    List<String> findAllAvailableSeatsByEventID(Integer eventID);

    @Query("SELECT s.seatID " +
            "FROM Seat s " +
            "WHERE s.seatID IN " +
            "(SELECT b.seatID " +
            "FROM Booking b " +
            "WHERE b.eventID = ?1)")
    List<String> findAllBookedSeatsByEvent(Integer eventID);

    @Query("SELECT s " +
            "FROM Seat s " +
            "WHERE s.seatID = ?1")
    Optional<Seat> findSeatBySeatID(String seatID);

    @Query("SELECT sz.cost " +
            "FROM SeatZone sz, Seat s " +
            "WHERE s.seatID = ?1 " +
            "AND s.zone = sz.zone")
    Integer findCostOfSeatBySeatID(String seatID);
}
