package com.codegym.model.facility;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "rentTypeId",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Facility> facilityList;
}
