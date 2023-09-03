package com.my.manga.place.dev.controllers;

import com.my.manga.place.dev.dtos.RolDTO;
import com.my.manga.place.dev.requests.RolRequest;
import com.my.manga.place.dev.services.IRolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/api/roles")
public class RolController {
    private final IRolService rolService;
    public RolController(IRolService rolService) {
        this.rolService = rolService;
    }
    @PostMapping
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<RolDTO> saveRol(@RequestBody RolDTO rolDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.rolService.saveRol(rolDTO));
    }
    @GetMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<RolDTO> findRolById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.rolService.findRolById(id));
    }
    @GetMapping
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<List<RolDTO>> findAllRoles(){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.rolService.findAllRoles());
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<?> deleteRolById(@PathVariable Long id){
        this.rolService.deleteRolById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<RolDTO> updateRolById(@PathVariable Long id, @RequestBody RolRequest rolRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.rolService.updateRolById(id, rolRequest));
    }

}