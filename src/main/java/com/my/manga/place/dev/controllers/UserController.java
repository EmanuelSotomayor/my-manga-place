package com.my.manga.place.dev.controllers;

import com.my.manga.place.dev.dtos.UserDTO;
import com.my.manga.place.dev.requests.UserRequest;
import com.my.manga.place.dev.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    private final IUserService userService;
    public UserController(IUserService userService){
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(userDTO));
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