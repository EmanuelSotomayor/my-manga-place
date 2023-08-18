package com.my.manga.place.dev.controllers;

import com.my.manga.place.dev.dtos.APIError;
import com.my.manga.place.dev.dtos.ValidationErrorDTO;
import com.my.manga.place.dev.exceptions.ParamException;
import com.my.manga.place.dev.utils.builders.impl.APIErrorBuilder;
import com.my.manga.place.dev.utils.builders.impl.ValidationErrorBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;
@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = ParamException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<APIError> handleInvalidArguments(ParamException ex){
        List<ValidationErrorDTO> errors = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(error -> this.mapError(error))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(APIErrorBuilder
                        .builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .fields(errors)
                        .build());
    }
    private ValidationErrorDTO mapError(ObjectError objectError) {
        if (objectError instanceof FieldError) {
            return ValidationErrorBuilder.builder()
                    .field( ((FieldError) objectError).getField() )
                    .message(objectError.getDefaultMessage())
                    .build();
        }
        return ValidationErrorBuilder.builder()
                .field(objectError.getObjectName())
                .message(objectError.getDefaultMessage())
                .build();
    }

}