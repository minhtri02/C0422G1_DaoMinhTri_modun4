package com.codegym.dto;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetailDto implements Validator {
    private Long id;
    private Contract contract;
    private AttachFacility attachFacility;
    private int quantity;

    public ContractDetailDto(Contract contract, AttachFacility attachFacility, int quantity) {
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
