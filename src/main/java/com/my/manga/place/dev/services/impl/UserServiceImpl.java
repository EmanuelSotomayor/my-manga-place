package com.my.manga.place.dev.services.impl;

import com.my.manga.place.dev.dtos.UserDTO;
import com.my.manga.place.dev.entities.Image;
import com.my.manga.place.dev.entities.User;
import com.my.manga.place.dev.exceptions.UserException;
import com.my.manga.place.dev.repository.UserRepository;
import com.my.manga.place.dev.requests.UserRequest;
import com.my.manga.place.dev.services.IImageService;
import com.my.manga.place.dev.services.IMessageService;
import com.my.manga.place.dev.services.IUserService;
import com.my.manga.place.dev.utils.builders.impl.UserDTOBuilder;
import com.my.manga.place.dev.utils.impl.ObjectMapperUtil;
import com.my.manga.place.dev.utils.mappers.UserMapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final IMessageService messageService;
    private final IImageService imageService;
    private final ObjectMapperUtil objectMapperUtil;
    public UserServiceImpl(UserRepository userRepository, IMessageService messageService,
                           IImageService imageService, ObjectMapperUtil objectMapperUtil){
        this.userRepository = userRepository;
        this.messageService = messageService;
        this.objectMapperUtil = objectMapperUtil;
        this.imageService = imageService;
    }
    @Override
    public UserDTO saveUser(UserDTO userDTO, MultipartFile file) throws IOException {

        Optional<User> userExists = this.userRepository.findUserByEmail(userDTO.getEmail());
            if(userExists.isPresent()){
                throw new UserException(this.messageService.getMessageProperty("user.are.exists"));
            }

        User userEntity = UserMapperUtil.userDTOtoUserEntity(userDTO);

        Image savedImage = this.imageService.saveImage(file);

        if(Objects.nonNull(savedImage)){
            userEntity.setImage(savedImage);
        }

        User savedUser = this.userRepository.save(userEntity);
        return UserMapperUtil.userEntityToUserDTO(savedUser);

    }
    @Override
    public UserDTO findUserById(Long id) {
        Optional<User> userExists = this.userRepository.findById(id);
        userExists.orElseThrow(() -> new UserException(this.messageService.getMessageProperty("user.not.found")));
        return UserMapperUtil.userEntityToUserDTO(userExists.get());
    }
    @Override
    public List<UserDTO> findAllUsers() {
        return UserMapperUtil.userEntitiesToUserDTOs(this.userRepository.findAll());
    }
    @Override
    public void deleteUserById(Long id) {
        Optional<User> userExists = this.userRepository.findById(id);
        userExists.orElseThrow(() -> new UserException(this.messageService.getMessageProperty("user.not.found")));
        this.userRepository.deleteById(id);
    }
    @Override
    public UserDTO updateUserById(Long id, UserRequest userRequest) {
        Optional<User> userExists = this.userRepository.findById(id);
        userExists.orElseThrow(() -> new UserException(this.messageService.getMessageProperty("user.not.found")));

        userExists.get().setName(userRequest.getName());
        userExists.get().setSurname(userRequest.getSurname());
        userExists.get().setUsername(userRequest.getUsername());
        userExists.get().setPassword(userRequest.getPassword());

        UserDTO userDTO = UserDTOBuilder.builder()
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .email(userExists.get().getEmail())
                .build();

        this.userRepository.save(userExists.get());
        return userDTO;

    }

}