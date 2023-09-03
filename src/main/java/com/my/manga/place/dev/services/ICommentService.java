package com.my.manga.place.dev.services;

import com.my.manga.place.dev.dtos.CommentDTO;
import com.my.manga.place.dev.dtos.CommentSimpleDTO;
import java.util.List;
public interface ICommentService {
    public CommentDTO saveComment(CommentSimpleDTO commentSimpleDTO);
    public void deleteCommentById(Long id);
    public CommentDTO updateCommentById(Long id, CommentSimpleDTO commentSimpleDTO);
    public CommentDTO findCommentById(Long id);
    public List<CommentDTO> findAllComments();

}
