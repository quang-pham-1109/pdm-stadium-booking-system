package com.example.demo.booking;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
class BookingID implements Serializable {
    private Integer eventID;
    private Integer customerID;
}
