package com.my.manga.place.dev.utils;

import com.my.manga.place.dev.dtos.UserDTO;
import com.my.manga.place.dev.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapperUtil {
    public static User userDTOtoUserEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setDeleted(userDTO.getDeleted());
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }
    public static UserDTO userEntityToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setDeleted(user.getDeleted());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

    public static List<UserDTO> userEntitiesToUserDTOs(List<User> users){
        return users.stream()
                .map(user -> userEntityToUserDTO(user))
                .collect(Collectors.toList());
    }
    public static List<User> userDTOsToUserEntities(List<UserDTO> userDTOs){
        return userDTOs.stream()
                .map(userDTO -> userDTOtoUserEntity(userDTO))
                .collect(Collectors.toList());
    }

}