package com.example.demo.paymentBill;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentBillService {
    private final PaymentBillRepository paymentBillRepository;

    public PaymentBillService(PaymentBillRepository paymentBillRepository) {
        this.paymentBillRepository = paymentBillRepository;
    }

    public List<PaymentBill> getAllPaymentBill() {
        return paymentBillRepository.findAll();
    }
}
