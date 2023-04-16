package com.example.demo.auth;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;

    private String lastName;
    private String email;

    private Date dateOfBirth;

    private String phoneNumber;
    private String address;
    private String password;
}
