package com.my.manga.place.dev.controllers;

import com.my.manga.place.dev.dtos.DislikeDTO;
import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.services.IDislikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/api/dislikes")
public class DislikeController {
    public final IDislikeService dislikeService;
    public DislikeController(IDislikeService dislikeService){
        this.dislikeService = dislikeService;
    }
    @PostMapping
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<Dislike> saveDislike(@RequestBody DislikeDTO dislikeDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.dislikeService.saveDislike(dislikeDTO));
    }
    @GetMapping
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<List<Dislike>> findAllDislikes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.dislikeService.findAllDislikes());
    }
    @GetMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<Dislike> findDislikeById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.dislikeService.findDislikeById(id));
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<?> deleteDislikeById(@PathVariable Long id){
        this.dislikeService.deleteDislikeById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<Dislike> updateDislikeById(@PathVariable Long id, @RequestBody DislikeDTO dislikeDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.dislikeService.updateDislikeById(id, dislikeDTO));
    }

}