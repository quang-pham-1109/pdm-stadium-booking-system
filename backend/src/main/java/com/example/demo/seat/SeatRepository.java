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


    @Query("SELECT s.seatID FROM Seat s")
    List<String> findAllToString();

    @Modifying
    @Transactional
    @Query("UPDATE Seat s SET s.price = ?1")
    void updateAllSeatPrice(Integer price);


    Optional<Seat> findSeatBySeatID(String seatID);
}
