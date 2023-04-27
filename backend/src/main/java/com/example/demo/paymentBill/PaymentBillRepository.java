package com.example.demo.paymentBill;

import com.example.demo.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PaymentBillRepository extends JpaRepository<PaymentBill, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE PaymentBill pb " +
            "SET pb.totalCost = ?2 " +
            "WHERE pb.paymentID = ?1")
    void updateTotalCostByPaymentBillID(Integer paymentBillID, Integer totalCost);

    @Query("SELECT pb " +
            "FROM PaymentBill pb " +
            "WHERE pb.customerID = ?1")
    List<PaymentBill> getByCustomerID(Integer customerID);
}
