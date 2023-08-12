package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.dtos.UserDTO;
import java.util.Date;

public interface IUserDTOBuilder extends IAbstractBuilder<UserDTO>{
    public IUserDTOBuilder name(String name);
    public IUserDTOBuilder surname(String surname);
    public IUserDTOBuilder username(String username);
    public IUserDTOBuilder email(String email);
    public IUserDTOBuilder password(String password);

}
