package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.entities.User;
import jakarta.persistence.*;

import java.util.Date;

public interface IUserBuilder extends IAbstractBuilder<User>{
    public IUserBuilder id(Long id);
    public IUserBuilder name(String name);
    public IUserBuilder surname(String surname);
    public IUserBuilder username(String username);
    public IUserBuilder email(String email);
    public IUserBuilder password(String password);
    public IUserBuilder createdAt(Date createdAt);
    public IUserBuilder deleted(Boolean deleted);

}
