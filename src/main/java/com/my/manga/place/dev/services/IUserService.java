package com.my.manga.place.dev.services;

import com.my.manga.place.dev.dtos.UserDTO;
import com.my.manga.place.dev.requests.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUserService {
    public UserDTO saveUser(UserDTO userDTO, MultipartFile file) throws IOException, MethodArgumentNotValidException;
    public UserDTO findUserById(Long id);
    public List<UserDTO> findAllUsers();
    public void deleteUserById(Long id);
    public UserDTO updateUserById(Long id, UserRequest userRequest);
}
