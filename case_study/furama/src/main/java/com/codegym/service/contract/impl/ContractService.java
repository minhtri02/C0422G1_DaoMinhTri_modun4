package com.codegym.service.contract.impl;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.repository.contract.IContractDetailRepository;
import com.codegym.repository.contract.IContractRepository;
import com.codegym.service.contract.IAttachFacilityRepository;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;


    @Override
    public Page<Contract> listContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void deleteContract(Long id) {
        contractRepository.delete(findById(id));
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public List<AttachFacility> listAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public List<ContractDetail> listContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> listContractDetail(Long contractId) {
        return contractDetailRepository.findByContract_Id(contractId);
    }
}
