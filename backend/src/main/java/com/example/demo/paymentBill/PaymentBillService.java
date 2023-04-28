package com.example.demo.paymentBill;

import com.example.demo.booking.Booking;
import com.example.demo.booking.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        if (bookings.size() == 0) {
            return;
        }

        for (Booking booking : bookings) {
            List<Booking> filteredBooking = bookingRepository.
                    getBookingByEventIDAndCustomerIDAndBookingDate(
                            booking.getEventID(),
                            booking.getCustomerID(),
                            booking.getBookingDate());
            if (filteredBooking.size() == 1) {
                initiatePaymentBill(
                        booking.getCustomerID(),
                        booking.getEventID(),
                        new Date(),
                        bookingRepository.getCostOfBooking(
                                booking.getEventID(),
                                booking.getSeatID()));
            } else {
                int total = 0;
                for (Booking booking1 : filteredBooking) {
                    total += bookingRepository.getCostOfBooking(
                            booking1.getEventID(),
                            booking1.getSeatID());
                }
                initiatePaymentBill(
                        booking.getCustomerID(),
                        booking.getEventID(),
                        new Date(),
                        total);
            }
            break;
        }
    }

    public PaymentBill initiatePaymentBill(Integer customerID,
                                           Integer eventID,
                                           Date billDate,
                                           Integer totalCost){
        var newPaymentBill = PaymentBill.builder()
                .customerID(customerID)
                .eventID(eventID)
                .billDate(billDate)
                .totalCost(totalCost)
                .build();
        return paymentBillRepository.save(newPaymentBill);
    }

    public List<PaymentBill> getByCustomerID(Integer customerID) {
        return paymentBillRepository.getByCustomerID(customerID);
    }
}
