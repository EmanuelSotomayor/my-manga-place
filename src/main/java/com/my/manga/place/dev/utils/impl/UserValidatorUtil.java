package com.my.manga.place.dev.utils.impl;

import com.my.manga.place.dev.entities.User;
import com.my.manga.place.dev.exceptions.ParamException;
import com.my.manga.place.dev.services.IMessageService;
import com.my.manga.place.dev.utils.IValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Objects;
public class UserValidatorUtil<T> implements IValidatorUtil<T> {
    private final IMessageService messageService;
    public UserValidatorUtil(IMessageService messageService) {
        this.messageService = messageService;
    }
    @Override
    public void validate(T t) throws MethodArgumentNotValidException {

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult((User) t, "t");

        User user = (User) t;

        if(Objects.isNull(user.getName()) || StringUtils.isEmpty(user.getName())
                || user.getName().length() < 4){
            bindingResult.addError(new FieldError("t", "name", this.messageService.getMessageProperty("user.field.name")));
        }

        if(Objects.isNull(user.getSurname()) || StringUtils.isEmpty(user.getSurname())
                || user.getSurname().length() < 4){
            bindingResult.addError(new FieldError("t", "surname", this.messageService.getMessageProperty("user.field.surname")));
        }

        if(Objects.isNull(user.getUsername()) || StringUtils.isEmpty(user.getSurname())
                || user.getUsername().length() < 4){
            bindingResult.addError(new FieldError("t", "username", this.messageService.getMessageProperty("user.field.username")));
        }

        if(Objects.isNull(user.getEmail()) || StringUtils.isEmpty(user.getEmail())
                || user.getEmail().length() <= 4){
            bindingResult.addError(new FieldError("t", "email", this.messageService.getMessageProperty("user.field.email")));
        }

        if(Objects.isNull(user.getPassword()) || StringUtils.isEmpty(user.getPassword())
                || user.getPassword().length() <= 4){
            bindingResult.addError(new FieldError("t", "password", this.messageService.getMessageProperty("user.field.password")));
        }

        if(bindingResult.hasErrors()){
            /*El primer parámetro queda nulo porque no le pasamos ningún parametro de método,
            directamente le pasamos los errores que almacenamos de los atributos que no cumplen las condiciones*/
            throw new ParamException(null, bindingResult);
        }

    }

}