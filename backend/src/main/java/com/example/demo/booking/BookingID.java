package com.example.demo.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
class BookingID implements Serializable {
    private Integer eventID;
    private Integer customerID;

}
