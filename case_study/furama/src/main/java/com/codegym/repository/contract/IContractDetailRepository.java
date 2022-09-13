package com.codegym.repository.contract;

import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    List<ContractDetail> findByContract_Id(Long contractId);
}
