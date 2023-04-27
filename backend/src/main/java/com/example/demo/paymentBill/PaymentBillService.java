package com.example.demo.paymentBill;

import com.example.demo.booking.Booking;
import com.example.demo.booking.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentBillService {
    private final PaymentBillRepository paymentBillRepository;
    private final BookingRepository bookingRepository;

    public PaymentBillService(PaymentBillRepository paymentBillRepository,
                              BookingRepository bookingRepository) {
        this.paymentBillRepository = paymentBillRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<PaymentBill> getAllPaymentBill() {
        return paymentBillRepository.findAll();
    }

    public void createANewBill() {
        List<Booking> bookings = bookingRepository.getBookingThatDoesNotHaveBill();
        for (Booking booking : bookings) {
            var newPaymentBill = PaymentBill.builder()
                    .customerID(booking.getCustomerID())
                    .billDate(booking.getBookingDate())
                    .eventID(booking.getEventID())
                    .totalCost(bookingRepository.getCostOfBooking(
                            booking.getEventID(),
                            booking.getSeatID()))
                    .build();
            paymentBillRepository.save(newPaymentBill);
        }
    }

//    Check if a new bill should be created or not
//    bill will be created if booking has unique:
//    eventID, customerID and bookingDate
}
