package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.dtos.ValidationErrorDTO;
import com.my.manga.place.dev.utils.builders.IValidationErrorBuilder;

public class ValidationErrorBuilder implements IValidationErrorBuilder {
    private ValidationErrorDTO validationErrorDTO;
    private ValidationErrorBuilder(){
        this.validationErrorDTO = new ValidationErrorDTO();
    }
    @Override
    public IValidationErrorBuilder field(String campo) {
        this.validationErrorDTO.setField(campo);
        return this;
    }
    @Override
    public IValidationErrorBuilder message(String mensaje) {
        this.validationErrorDTO.setMessage(mensaje);
        return this;
    }
    public static ValidationErrorBuilder builder(){
        return new ValidationErrorBuilder();
    }
    @Override
    public ValidationErrorDTO build() {
        return this.validationErrorDTO;
    }

}