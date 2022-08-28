package com.codegym.model.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGuestType;
    private String guestTypeName;

    @OneToMany(mappedBy = "guestType")
    private List<Customer> customerList;
}
