package com.my.manga.place.dev.dtos;

import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.entities.Like;
public class CommentDTO {
    private Long id;
    private String text;
    private Like like;
    private Dislike dislike;
    private Boolean deleted;
    public CommentDTO(){}
    public CommentDTO(Long id, String text, Like like, Dislike dislike, Boolean deleted) {
        this.id = id;
        this.text = text;
        this.like = like;
        this.dislike = dislike;
        this.deleted = deleted;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Like getLike() {
        return like;
    }
    public void setLike(Like like) {
        this.like = like;
    }
    public Dislike getDislike() {
        return dislike;
    }
    public void setDislike(Dislike dislike) {
        this.dislike = dislike;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", like=" + like +
                ", dislike=" + dislike +
                ", deleted=" + deleted +
                '}';
    }

}