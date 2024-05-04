package com.quest.demographic.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quest.demographic.dto.UserDTO;
import com.quest.demographic.exception.OperationalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
@Slf4j
public class CommonUtils {


    private final ObjectMapper objectMapper;

    public CommonUtils(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Object convertIntoObject(Object record, Class<?> classType) {
        try {
            return objectMapper.convertValue(record, classType);
        } catch (Exception z) {
            log.error("Object conversion failed {} {}", classType, z.getMessage());
            throw new OperationalException("Object conversion failed " + z.getMessage());
        }
    }


    public Object convertIntoList(Object record, TypeReference<List<UserDTO>> classType) {
        try {
            return objectMapper.convertValue(record, classType);
        } catch (Exception z) {
            log.error("Object conversion failed {} {}", classType, z.getMessage());
            throw new OperationalException("Object conversion failed " + z.getMessage());
        }
    }


    public String prepareErrorMessage(BindingResult bindingResult) {
        StringBuilder builder = new StringBuilder();
        for (ObjectError allError : bindingResult.getAllErrors()) {
            builder.append(allError.getDefaultMessage());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
