package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.dtos.CommentDTO;
import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.entities.Like;
import com.my.manga.place.dev.utils.builders.ICommentDTOBuilder;
public class CommentDTOBuilder implements ICommentDTOBuilder {
    private CommentDTO commentDTO;
    private CommentDTOBuilder(){
        this.commentDTO = new CommentDTO();
    }
    @Override
    public CommentDTO build() {
        return this.commentDTO;
    }
    @Override
    public ICommentDTOBuilder id(Long id) {
        this.commentDTO.setId(id);
        return this;
    }
    @Override
    public ICommentDTOBuilder text(String text) {
        this.commentDTO.setText(text);
        return this;
    }
    @Override
    public ICommentDTOBuilder like(Like like) {
        this.commentDTO.setLike(like);
        return this;
    }
    @Override
    public ICommentDTOBuilder dislike(Dislike dislike) {
        this.commentDTO.setDislike(dislike);
        return this;
    }
    @Override
    public ICommentDTOBuilder deleted(Boolean deleted) {
        this.commentDTO.setDeleted(deleted);
        return this;
    }
    public static CommentDTOBuilder builder(){
        return new CommentDTOBuilder();
    }

}