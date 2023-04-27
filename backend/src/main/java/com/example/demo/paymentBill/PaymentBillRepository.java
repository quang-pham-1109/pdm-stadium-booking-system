package com.example.demo.paymentBill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentBillRepository extends JpaRepository<PaymentBill, Integer> {
}
