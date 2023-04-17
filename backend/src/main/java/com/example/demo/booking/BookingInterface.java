package com.example.demo.booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInterface extends JpaRepository<Booking, Integer> {

}
