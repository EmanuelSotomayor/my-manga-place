package com.my.manga.place.dev.utils;

import org.springframework.web.bind.MethodArgumentNotValidException;
public interface IValidatorUtil<T>{
    public void validate(T t) throws MethodArgumentNotValidException;

}
