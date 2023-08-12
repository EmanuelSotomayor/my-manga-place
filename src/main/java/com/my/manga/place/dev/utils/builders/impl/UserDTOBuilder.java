package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.dtos.UserDTO;
import com.my.manga.place.dev.utils.builders.IUserDTOBuilder;
import java.util.Date;

public class UserDTOBuilder implements IUserDTOBuilder {
    private UserDTO userDTO;
    private UserDTOBuilder(){
        this.userDTO = new UserDTO();
    }
    @Override
    public UserDTO build() {
        return this.userDTO;
    }
    @Override
    public IUserDTOBuilder name(String name) {
        this.userDTO.setName(name);
        return this;
    }
    @Override
    public IUserDTOBuilder surname(String surname) {
        this.userDTO.setSurname(surname);
        return this;
    }
    @Override
    public IUserDTOBuilder username(String username) {
        this.userDTO.setUsername(username);
        return this;
    }
    @Override
    public IUserDTOBuilder email(String email) {
        this.userDTO.setEmail(email);
        return this;
    }
    @Override
    public IUserDTOBuilder password(String password) {
        this.userDTO.setPassword(password);
        return this;
    }
    public static UserDTOBuilder builder(){
        return new UserDTOBuilder();
    }

}
