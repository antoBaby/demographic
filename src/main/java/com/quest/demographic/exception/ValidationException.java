package com.quest.demographic.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@Getter
public class ValidationException extends Exception {

    BindingResult bindingResult;

    public ValidationException(BindingResult result) {
        super(HttpStatus.BAD_REQUEST.toString());
        this.bindingResult = result;
    }
}
