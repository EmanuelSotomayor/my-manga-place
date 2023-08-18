package com.my.manga.place.dev.utils.impl;

import com.my.manga.place.dev.entities.Rol;
import com.my.manga.place.dev.exceptions.ParamException;
import com.my.manga.place.dev.services.IMessageService;
import com.my.manga.place.dev.utils.IValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Objects;
public class RolValidatorUtil<T> implements IValidatorUtil<T> {
    private final IMessageService messageService;
    public RolValidatorUtil(IMessageService messageService){
        this.messageService = messageService;
    }
    @Override
    public void validate(T t) throws MethodArgumentNotValidException {

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult((Rol) t, "t");

        Rol rol = (Rol) t;

        if(Objects.isNull(rol.getName()) || StringUtils.isEmpty(rol.getName())
                || rol.getName().length() <= 4){
            bindingResult.addError(new FieldError("t", "name", this.messageService.getMessageProperty("user.field.name")));
        }

        if(Objects.isNull(rol.getDescription())
                || StringUtils.isEmpty(rol.getDescription())){
            bindingResult.addError(new FieldError("t", "description", this.messageService.getMessageProperty("user.field.name")));
        }

        if(bindingResult.hasErrors()){
            /*El primer parámetro queda nulo porque no le pasamos ningún parametro de método,
            directamente le pasamos los errores que almacenamos de los atributos que no cumplen las condiciones*/
            throw new ParamException(null, bindingResult);
        }

    }
}
