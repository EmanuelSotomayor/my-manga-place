package com.my.manga.place.dev.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
@Component
public class ObjectMapperUtil {
    private final ObjectMapper objectMapper;
    public ObjectMapperUtil(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

}
