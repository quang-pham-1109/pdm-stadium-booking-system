package com.example.demo.paymentBill;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/payment-bill")
public class PaymentBillController {
    private final PaymentBillService paymentBillService;

    public PaymentBillController(PaymentBillService paymentBillService) {
        this.paymentBillService = paymentBillService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentBill>> getPaymentBills() {
        paymentBillService.createANewBill();
        return new  ResponseEntity<>(paymentBillService.getAllPaymentBill(), HttpStatus.OK);
    }

}
