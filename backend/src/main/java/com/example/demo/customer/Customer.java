package com.example.demo.customer;

import com.example.demo.booking.Booking;
import com.example.demo.paymentBill.PaymentBill;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer implements UserDetails {

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
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

//    //Relationships
//    @OneToMany(mappedBy = "customer")
//    private Set<Booking> booking;
//
//    @OneToMany(mappedBy = "customer")
//    private Set<PaymentBill> paymentBill;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
