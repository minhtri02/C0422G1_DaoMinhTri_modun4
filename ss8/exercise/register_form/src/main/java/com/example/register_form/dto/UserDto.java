package com.example.register_form.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Validator {

    @NotBlank(message = "please enter your first name")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank(message = "please enter your last name")
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank(message = "please enter your phone")
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$", message = "your phone number is wrong!")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate age;

    @javax.validation.constraints.Email
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        try{
            UserDto userDto = (UserDto) target;
            LocalDate now = LocalDate.now();
            if ((now.getYear() - userDto.getAge().getYear()) <= 18) {
                errors.rejectValue("age", "age.err", "Wrong format day!!! ");
            }
        }catch (Exception e){
            errors.rejectValue("age", "age.err", "day not null!! ");
        }

    }
}
