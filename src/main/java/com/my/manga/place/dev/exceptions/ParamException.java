package com.my.manga.place.dev.exceptions;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ParamException extends MethodArgumentNotValidException {
    public ParamException(MethodParameter parameter, BindingResult bindingResult){
        super(parameter, bindingResult);
    }

}
