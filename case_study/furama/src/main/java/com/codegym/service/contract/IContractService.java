package com.codegym.service.contract;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    Page<Contract> listContract(String nameFacility, String nameCustomer, Pageable pageable);


    Page<Contract> listContract(Pageable pageable);

    List<Contract> findAll();

    void saveContract(Contract contract);

    void saveContractDetail(ContractDetail contractDetail);

    void deleteContract(Long id);

    Contract findById(Long id);

    List<AttachFacility> listAttachFacility();

    List<ContractDetail> listContractDetail();

    List<ContractDetail> listContractDetail(Long contractId);
}
