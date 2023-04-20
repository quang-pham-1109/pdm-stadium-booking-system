package com.example.demo.seatZone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatZoneRepository extends JpaRepository<SeatZone, String> {

}
