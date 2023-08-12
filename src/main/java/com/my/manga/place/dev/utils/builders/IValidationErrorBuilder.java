package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.dtos.ValidationErrorDTO;
public interface IValidationErrorBuilder extends IAbstractBuilder<ValidationErrorDTO> {
    public IValidationErrorBuilder field(String campo);
    public IValidationErrorBuilder message(String mensaje);

}
