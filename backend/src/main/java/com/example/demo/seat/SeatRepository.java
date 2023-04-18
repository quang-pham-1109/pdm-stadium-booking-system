package com.example.demo.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {

    @Transactional
    @Query("UPDATE Seat s SET s.isBooked = TRUE WHERE s.seatID = ?1")
    @Modifying
    public abstract void bookSeat(String seatID);
}
