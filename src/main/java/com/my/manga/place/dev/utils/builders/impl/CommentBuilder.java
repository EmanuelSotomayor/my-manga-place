package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.entities.Comment;
import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.entities.Like;
import com.my.manga.place.dev.utils.builders.ICommentBuilder;
public class CommentBuilder implements ICommentBuilder {
    private Comment comment;
    private CommentBuilder(){this.comment = new Comment();}
    @Override
    public Comment build() {
        return this.comment;
    }
    @Override
    public ICommentBuilder id(Long id) {
        this.comment.setId(id);
        return this;
    }
    @Override
    public ICommentBuilder text(String text) {
        this.comment.setText(text);
        return this;
    }
    @Override
    public ICommentBuilder like(Like like) {
        this.comment.setLike(like);
        return this;
    }
    @Override
    public ICommentBuilder dislike(Dislike dislike) {
        this.comment.setDislike(dislike);
        return this;
    }
    @Override
    public ICommentBuilder deleted(Boolean deleted) {
        this.comment.setDeleted(deleted);
        return this;
    }
    public static CommentBuilder builder(){
        return new CommentBuilder();
    }

}