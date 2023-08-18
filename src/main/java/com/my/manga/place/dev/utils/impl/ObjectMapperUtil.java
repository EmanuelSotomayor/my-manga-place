package com.my.manga.place.dev.utils.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.manga.place.dev.utils.IObjectMapperUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class ObjectMapperUtil<T, S> implements IObjectMapperUtil<T, S> {
    private final ObjectMapper objectMapper;
    public ObjectMapperUtil(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }
    @Override
    public HttpEntity<String> parseObjectToJsonString(S s, HttpHeaders headers) throws JsonProcessingException {
         return new HttpEntity<String>(objectMapper.writeValueAsString(s), headers);
    }
    @Override
    public T parseStringToObject(String data, Class<?> clazz) throws JsonProcessingException {
        return (T) this.objectMapper.readValue(data, clazz);
    }

}