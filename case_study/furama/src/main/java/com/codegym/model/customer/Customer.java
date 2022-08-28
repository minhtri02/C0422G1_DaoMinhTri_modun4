package com.codegym.model.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfBirth;
    private Integer gender;
    private String personalCode;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    private GuestType guestType;
}
