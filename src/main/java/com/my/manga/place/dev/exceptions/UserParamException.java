package com.my.manga.place.dev.exceptions;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class UserParamException extends MethodArgumentNotValidException {
    public UserParamException(MethodParameter parameter, BindingResult bindingResult){
        super(parameter, bindingResult);
    }

}
