package com.my.manga.place.dev.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.my.manga.place.dev.dtos.UserDTO;
import com.my.manga.place.dev.requests.UserRequest;
import com.my.manga.place.dev.services.IUserService;
import com.my.manga.place.dev.utils.impl.ObjectMapperUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    private final IUserService userService;
    private final ObjectMapperUtil objectMapperUtil;
    public UserController(IUserService userService, ObjectMapperUtil objectMapperUtil){
        this.userService = userService;
        this.objectMapperUtil = objectMapperUtil;
    }

    /*
    *
    * Retorna un objeto UserDTO, a su vez, recibimos por parámetro el objeto del
    * tipo MultipartFile y el objeto del tipo String userDTO utilizando las anotaciones
    * @RequestPart en los 2 casos para vincular un elemento de una solicitud HTTP multipart/form-data
    * a un parámetro de método en un controlador.
    * En la petición HTTP, enviamos al UserDTO deserializado como un String formateado como JSON,
    * luego en el cuerpo del método del controlador, necesitamos serializarlo a la clase JAVA,
    * para poder almacenarlo en la base de datos, para ello utilizamos ObjectMapper.
    *
    * @param String userDTO
    * @param MultipartFile file
    * @return UserDTO
    * */
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UserDTO> saveUser(@RequestPart("userDTO") String userDTO,
                                            @RequestPart("file") MultipartFile file) throws JsonProcessingException, IOException, MethodArgumentNotValidException {
        UserDTO userDTOParsed = (UserDTO) this.objectMapperUtil.parseStringToObject(userDTO, UserDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(userDTOParsed, file));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.userService.findUserById(id));
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.userService.findAllUsers());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        this.userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.updateUserById(id, userRequest));
    }

}