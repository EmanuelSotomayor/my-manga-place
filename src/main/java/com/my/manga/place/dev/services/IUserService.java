package com.my.manga.place.dev.services;

import com.my.manga.place.dev.dtos.UserDTO;
import com.my.manga.place.dev.requests.UserRequest;
import java.util.List;

public interface IUserService {
    public UserDTO saveUser(UserDTO userDTO);
    public UserDTO findUserById(Long id);
    public List<UserDTO> findAllUsers();
    public void deleteUserById(Long id);
    public UserDTO updateUserById(Long id, UserRequest userRequest);
}
