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
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;
    private String educationName;
    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

    public EducationDegree(String educationName, List<Employee> employeeList) {
        this.educationName = educationName;
        this.employeeList = employeeList;
    }
}

