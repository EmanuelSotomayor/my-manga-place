package com.my.manga.place.dev.services.impl;

import com.my.manga.place.dev.dtos.CommentDTO;
import com.my.manga.place.dev.dtos.CommentSimpleDTO;
import com.my.manga.place.dev.entities.Comment;
import com.my.manga.place.dev.repository.CommentRepository;
import com.my.manga.place.dev.services.ICommentService;
import com.my.manga.place.dev.services.IMessageService;
import com.my.manga.place.dev.utils.builders.impl.CommentBuilder;
import com.my.manga.place.dev.utils.builders.impl.CommentDTOBuilder;
import com.my.manga.place.dev.utils.builders.impl.DislikeBuilder;
import com.my.manga.place.dev.utils.builders.impl.LikeBuilder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CommentServiceImpl implements ICommentService {
    private final IMessageService messageService;
    private final CommentRepository commentRepository;
    public CommentServiceImpl(IMessageService messageService, CommentRepository commentRepository){
        this.messageService = messageService;
        this.commentRepository = commentRepository;
    }
    @Override
    public CommentDTO saveComment(CommentSimpleDTO commentSimpleDTO) {
        Comment savedComment = this.commentRepository.save(CommentBuilder.builder()
                .text(commentSimpleDTO.getText())
                .like(LikeBuilder.builder()
                        .counter(commentSimpleDTO.getLikeCounter())
                        .build())
                .dislike(DislikeBuilder.builder()
                        .counter(commentSimpleDTO.getDislikeCounter())
                        .build())
                .build());
        return CommentDTOBuilder.builder()
                .id(savedComment.getId())
                .text(savedComment.getText())
                .like(savedComment.getLike())
                .dislike(savedComment.getDislike())
                .deleted(savedComment.getDeleted())
                .build();
    }
    @Override
    public void deleteCommentById(Long id) {
        Optional<Comment> commentExists = this.commentRepository.findById(id);
        commentExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("comment.not.found")));
        this.commentRepository.deleteById(id);
    }
    @Override
    public CommentDTO updateCommentById(Long id, CommentSimpleDTO commentSimpleDTO) {
        Optional<Comment> commentExists = this.commentRepository.findById(id);
        commentExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("comment.not.found")));
        commentExists.get().getLike().setCounter(commentSimpleDTO.getLikeCounter());
        commentExists.get().getDislike().setCounter(commentSimpleDTO.getDislikeCounter());
        commentExists.get().setText(commentSimpleDTO.getText());
        this.commentRepository.save(commentExists.get());
        return CommentDTOBuilder.builder()
                .id(commentExists.get().getId())
                .text(commentExists.get().getText())
                .like(commentExists.get().getLike())
                .dislike(commentExists.get().getDislike())
                .deleted(commentExists.get().getDeleted())
                .build();
    }
    @Override
    public CommentDTO findCommentById(Long id) {
        Optional<Comment> commentExists = this.commentRepository.findById(id);
        commentExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("comment.not.found")));
        return CommentDTOBuilder.builder()
                .id(commentExists.get().getId())
                .text(commentExists.get().getText())
                .like(commentExists.get().getLike())
                .dislike(commentExists.get().getDislike())
                .deleted(commentExists.get().getDeleted())
                .build();
    }
    @Override
    public List<CommentDTO> findAllComments() {
        return this.commentRepository.findAll()
                .stream()
                .map(comment -> CommentDTOBuilder.builder()
                        .id(comment.getId())
                        .text(comment.getText())
                        .like(comment.getLike())
                        .dislike(comment.getDislike())
                        .deleted(comment.getDeleted())
                        .build())
                .collect(Collectors.toList());
    }

}