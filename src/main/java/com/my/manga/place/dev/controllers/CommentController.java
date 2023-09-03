package com.my.manga.place.dev.controllers;

import com.my.manga.place.dev.dtos.CommentDTO;
import com.my.manga.place.dev.dtos.CommentSimpleDTO;
import com.my.manga.place.dev.services.ICommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {
    private final ICommentService commentService;
    public CommentController(ICommentService commentService){
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentSimpleDTO commentSimpleDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.saveComment(commentSimpleDTO));
    }
    @GetMapping
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<List<CommentDTO>> findAllComments(){
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.findAllComments());
    }
    @GetMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<CommentDTO> findCommentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.findCommentById(id));
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<?> deleteCommentById(@PathVariable Long id){
        this.commentService.deleteCommentById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/{id}")
    @CrossOrigin(origins = "${cross.origin}", allowedHeaders = "*")
    public ResponseEntity<CommentDTO> updateCommentById(@PathVariable Long id, @RequestBody CommentSimpleDTO commentSimpleDTO){
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.updateCommentById(id, commentSimpleDTO));
    }

}