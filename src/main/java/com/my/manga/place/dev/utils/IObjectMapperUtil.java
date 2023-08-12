package com.my.manga.place.dev.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public interface IObjectMapperUtil<T, S> {
    public HttpEntity<String> parseObjectToJsonString(S s, HttpHeaders httpHeaders) throws JsonProcessingException;
    public T parseGenericJsonToObject(S s, Class<?> clazz) throws JsonProcessingException;

}