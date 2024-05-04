package com.quest.demographic.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class ContactAgeValidator implements ConstraintValidator<AgeValidator, LocalDate> {


    @Override
    public void initialize(AgeValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null)
            return false;

        Period period = Period.between(value, LocalDate.now());
        int years = period.getYears();
        if (years < 16)
            return false;

        return true;
    }

}
