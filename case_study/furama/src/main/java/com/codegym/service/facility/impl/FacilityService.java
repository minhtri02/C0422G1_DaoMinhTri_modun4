package com.codegym.service.facility.impl;

import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.repository.facility.IFacilityTypeRepository;
import com.codegym.repository.facility.IRentTypeRepository;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    IFacilityRepository iFacilityRepository;

    @Autowired
    IFacilityTypeRepository iFacilityTypeRepository;

    @Autowired
    IRentTypeRepository iRentTypeRepository;

    @Override
    public Page<Facility> listFacility(String name, Pageable pageable) {
        return this.iFacilityRepository.findAllByNameFacilityContaining(name,pageable);
    }

    @Override
    public List<FacilityType> listFacilityType() {
        return this.iFacilityTypeRepository.findAll();
    }

    @Override
    public List<RentType> listRentType() {
        return this.iRentTypeRepository.findAll();
    }

    @Override
    public void saveFacility(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public void deleteFacility(Integer id) {
        this.iFacilityRepository.delete(this.iFacilityRepository.findById(id).orElse(null));
    }

    @Override
    public Facility findById(Integer id) {
        return this.iFacilityRepository.findById(id).orElse(null);
    }
}
