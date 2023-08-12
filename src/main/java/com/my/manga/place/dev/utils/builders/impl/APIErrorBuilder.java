package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.dtos.APIError;
import com.my.manga.place.dev.dtos.ValidationErrorDTO;
import org.springframework.http.HttpStatus;
import java.util.List;
import com.my.manga.place.dev.utils.builders.IAPIErrorBuilder;
public class APIErrorBuilder implements IAPIErrorBuilder {
    private APIError apiError;
    private APIErrorBuilder(){
        this.apiError = new APIError();
    }
    @Override
    public IAPIErrorBuilder status(HttpStatus httpStatus) {
        this.apiError.setStatus(httpStatus);
        return this;
    }
    @Override
    public IAPIErrorBuilder fields(List<ValidationErrorDTO> fields) {
        this.apiError.setErrorFields(fields);
        return this;
    }
    public static APIErrorBuilder builder(){
        return new APIErrorBuilder();
    }
    @Override
    public APIError build() {
        return this.apiError;
    }

}