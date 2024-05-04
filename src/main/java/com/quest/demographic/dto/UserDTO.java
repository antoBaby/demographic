package com.quest.demographic.dto;

import com.quest.demographic.utils.AgeValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "PPS Number is mandatory")
    private String pps;
    @AgeValidator
    private LocalDate dob;
    private String phone;

}