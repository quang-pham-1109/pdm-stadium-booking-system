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

        if (bookings.size() == 0) {
            return;
        }

        for (Booking booking: bookings) {
            List<Booking> filteredBooking = bookingRepository.
                    getBookingByEventIDAndCustomerIDAndBookingDate(
                            booking.getEventID(),
                            booking.getCustomerID(),
                            booking.getBookingDate());
            if (filteredBooking.size() == 1) {
                System.out.println("Single booking found");
                var newPaymentBill = PaymentBill.builder()
                        .customerID(booking.getCustomerID())
                        .billDate(booking.getBookingDate())
                        .eventID(booking.getEventID())
                        .totalCost(bookingRepository.getCostOfBooking(
                                booking.getEventID(),
                                booking.getSeatID()))
                        .build();
                paymentBillRepository.save(newPaymentBill);
            } else {
                System.out.println("Multiple booking found");
                int total = 0;
                for (Booking booking1: filteredBooking) {
                    total += bookingRepository.getCostOfBooking(
                            booking1.getEventID(),
                            booking1.getSeatID());
                }
                var newPaymentBill = PaymentBill.builder()
                        .customerID(booking.getCustomerID())
                        .billDate(booking.getBookingDate())
                        .eventID(booking.getEventID())
                        .totalCost(total)
                        .build();
                paymentBillRepository.save(newPaymentBill);
            }
        }

    }

    public void updateAnExistingBill(){

    }

    public List<PaymentBill> getByCustomerID(Integer customerID) {
        return paymentBillRepository.getByCustomerID(customerID);
    }


//    Check if a new bill should be created or not
//    bill will be created if booking has unique:
//    eventID, customerID and bookingDate
}
