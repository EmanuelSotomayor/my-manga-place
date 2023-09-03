package com.my.manga.place.dev.controllers;

import com.my.manga.place.dev.dtos.LikeDTO;
import com.my.manga.place.dev.entities.Like;
import com.my.manga.place.dev.services.ILikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/likes")
public class LikeController {
    public final ILikeService likeService;
    public LikeController(ILikeService likeService){
        this.likeService = likeService;
    }
    @PostMapping
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<Like> saveLike(@RequestBody LikeDTO likeDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.likeService.saveLike(likeDTO));
    }
    @GetMapping
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<List<Like>> findAllLikes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.likeService.findAllLikes());
    }
    @GetMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<Like> findLikeById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.likeService.findLikeById(id));
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<?> deleteLikeById(@PathVariable Long id){
        this.likeService.deleteLikeById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<Like> updateLikeById(@PathVariable Long id, @RequestBody LikeDTO likeDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.likeService.updateLikeById(id, likeDTO));
    }

}