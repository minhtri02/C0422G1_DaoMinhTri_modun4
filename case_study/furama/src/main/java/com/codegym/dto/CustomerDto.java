package com.codegym.dto;

import com.codegym.model.customer.GuestType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Validator {

    private Integer id;
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^([A-Z][a-z]+\\s?){1,4}$",message = "Name is mandatory")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfBirth;
    private String gender;
    @NotBlank(message = "please enter your personalCode")
    private String personalCode;
    @NotBlank(message = "please enter your phone")
    @Pattern(regexp = "^(84|0[35789])+([0-9]{8})$", message = "your phone number is wrong!")
    private String phoneNumber;
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;
    @NotBlank(message = "please enter your address")
    private String address;
    private GuestType guestType;

    public CustomerDto(String name, LocalDate dayOfBirth, String gender, String personalCode, String phoneNumber, String email, String address) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.personalCode = personalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        try{
            CustomerDto userDto = (CustomerDto) target;
            LocalDate now = LocalDate.now();
            if ((now.getYear() - userDto.getDayOfBirth().getYear()) <= 18) {
                errors.rejectValue("dayOfBirth", "dayOfBirth.err", "Wrong format day!!! ");
            }
        }catch (Exception e){
            errors.rejectValue("dayOfBirth", "dayOfBirth.err", "day not null!! ");
        }

    }
}
