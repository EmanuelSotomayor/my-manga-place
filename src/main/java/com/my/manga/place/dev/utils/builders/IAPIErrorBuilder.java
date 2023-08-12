package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.dtos.APIError;
import com.my.manga.place.dev.dtos.ValidationErrorDTO;
import org.springframework.http.HttpStatus;
import java.util.List;
public interface IAPIErrorBuilder extends IAbstractBuilder<APIError> {
    public IAPIErrorBuilder status(HttpStatus httpStatus);
    public IAPIErrorBuilder fields(List<ValidationErrorDTO> fields);

}
