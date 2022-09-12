package com.codegym.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "divition")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private String divisionName;
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

    public Division(String divisionName, List<Employee> employeeList) {
        this.divisionName = divisionName;
        this.employeeList = employeeList;
    }
}

