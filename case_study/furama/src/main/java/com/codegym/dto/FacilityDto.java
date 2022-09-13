package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDto implements Validator {

    private Integer id;
    @NotBlank(message = "Please enter")
    @Pattern(regexp = "^([A-Z][a-z]+\\s?){1,4}$",message = "Enter the wrong format!")
    String nameFacility;
    @Min(0)
    Integer area;
    @Min(0)
    Double cost;
    @Min(0)
    Integer maxPeople;
    @NotBlank
    String standardRoom;
    String descriptionOtherConvenience;
    @Min(0)
    Double poolArea;
    @Min(0)
    Integer numberOfFloors;
    String facilityFree;
    private RentType rentTypeId;
    private FacilityType facilityTypeId;
    private List<Contract> contractList;

    public FacilityDto(String nameFacility, Integer area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, String facilityFree, RentType rentTypeId, FacilityType facilityTypeId, List<Contract> contractList) {
        this.nameFacility = nameFacility;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
        this.contractList = contractList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
