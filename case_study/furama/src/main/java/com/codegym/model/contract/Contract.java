package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDay;
    private LocalDate endDay;
    private double deposit;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "idCustomer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facility;
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ContractDetail> contractDetail;

    public Contract(LocalDate startDay, LocalDate endDay, double deposit, Customer customer, Employee employee, Facility facility, List<ContractDetail> contractDetail) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.contractDetail = contractDetail;
    }
}