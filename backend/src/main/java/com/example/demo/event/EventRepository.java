package com.example.demo.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("SELECT e FROM Event e WHERE e.eventID = ?1")
    Optional<Event> findEventByEventID(Integer eventID);

    @Query("SELECT e.availableSeats FROM Event e WHERE e.eventID = ?1")
    Optional<Integer> findAvailableSeatsByEventID(Integer eventID);


    @Transactional
    @Modifying
    @Query("UPDATE Event e SET e.availableSeats = e.availableSeats - 1 WHERE e.eventID = ?1")
    void decreaseAvailableSeatsByEventID(Integer eventID);
}
