package com.codegym.model.facility;

import com.codegym.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String nameFacility;
    Integer area;
    Double cost;
    Integer maxPeople;
    String standardRoom;
    String descriptionOtherConvenience;
    Double poolArea;
    Integer numberOfFloors;
    String facilityFree;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    private RentType rentTypeId;

    @ManyToOne
    @JoinColumn(name = "facility_type_id",referencedColumnName = "id")
    private FacilityType facilityTypeId;

    @OneToMany(mappedBy = "facility")
    @JsonBackReference
    private List<Contract> contractList;

}
