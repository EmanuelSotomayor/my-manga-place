package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.entities.User;
import com.my.manga.place.dev.utils.builders.IUserBuilder;
import java.util.Date;
public class UserBuilder implements IUserBuilder {
    private User user;
    private UserBuilder(){
        this.user = new User();
    }
    @Override
    public User build() {
        return this.user;
    }
    @Override
    public IUserBuilder id(Long id) {
        this.user.setId(id);
        return this;
    }
    @Override
    public IUserBuilder name(String name) {
        this.user.setName(name);
        return this;
    }
    @Override
    public IUserBuilder surname(String surname) {
        this.user.setSurname(surname);
        return this;
    }
    @Override
    public IUserBuilder username(String username) {
        this.user.setUsername(username);
        return this;
    }
    @Override
    public IUserBuilder email(String email) {
        this.user.setEmail(email);
        return this;
    }
    @Override
    public IUserBuilder password(String password) {
        this.user.setPassword(password);
        return this;
    }
    @Override
    public IUserBuilder createdAt(Date createdAt) {
        this.user.setCreatedAt(createdAt);
        return this;
    }
    @Override
    public IUserBuilder deleted(Boolean deleted) {
        this.user.setDeleted(deleted);
        return this;
    }
    public static UserBuilder builder(){
        return new UserBuilder();
    }

}