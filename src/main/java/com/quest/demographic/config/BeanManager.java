package com.quest.demographic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class BeanManager {
    @Autowired
    Jackson2ObjectMapperBuilder mapperBuilder;

    @Bean
    public ObjectMapper objectMapper() {
        return mapperBuilder.build();
    }
}
