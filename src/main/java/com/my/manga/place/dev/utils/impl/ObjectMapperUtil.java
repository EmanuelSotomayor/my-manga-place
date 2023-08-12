package com.my.manga.place.dev.utils.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.manga.place.dev.utils.IObjectMapperUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
public class ObjectMapperUtil<T, S> implements IObjectMapperUtil<T, S> {
    private final ObjectMapper objectMapper;
    public ObjectMapperUtil(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }
    @Override
    public HttpEntity<String> parseObjectToJsonString(S s, HttpHeaders headers) throws JsonProcessingException {

        String jsonRequest = objectMapper.writeValueAsString(s);

         return new HttpEntity<String>(jsonRequest, headers);

    }
    @Override
    public T parseGenericJsonToObject(S s, Class<?> clazz) throws JsonProcessingException {
        return null;
    }

}