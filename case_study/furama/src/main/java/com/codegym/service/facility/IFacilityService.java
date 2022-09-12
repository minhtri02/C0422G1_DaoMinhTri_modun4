package com.codegym.service.facility;

import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> listFacility(String name, Pageable pageable);

    List<Facility> findAll();

    List<FacilityType> listFacilityType();

    List<RentType> listRentType();

    void saveFacility(Facility facility);

    void deleteFacility(Integer id);

    Facility findById(Integer id);
}
