package com.example.demo.customer;

import com.example.demo.booking.Booking;
import com.example.demo.paymentBill.PaymentBill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Customer")
public class Customer {

    @Id
    @SequenceGenerator( //Generate a sequence start at 1 and increment by 1
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1 //ID increment by 1 everytime
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private String address;

    //Relationships
    @OneToMany(mappedBy = "customer")
    private Set<Booking> booking;

    @OneToMany(mappedBy = "customer")
    private Set<PaymentBill> paymentBill;


    public Customer() {

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
