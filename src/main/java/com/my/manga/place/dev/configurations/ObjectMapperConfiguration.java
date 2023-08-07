package com.my.manga.place.dev.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ObjectMapperConfiguration {
    @Bean
    private ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
