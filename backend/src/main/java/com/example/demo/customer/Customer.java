package com.example.demo.customer;

import com.example.demo.booking.Booking;
import com.example.demo.paymentBill.PaymentBill;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    //Relationships
    @OneToMany(mappedBy = "customer")
    private Set<Booking> booking;

    @OneToMany(mappedBy = "customer")
    private Set<PaymentBill> paymentBill;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
