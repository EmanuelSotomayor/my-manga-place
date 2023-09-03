package com.my.manga.place.dev.dtos;

import java.math.BigInteger;

public class CommentSimpleDTO {
    private String text;
    private BigInteger likeCounter;
    private BigInteger dislikeCounter;
    public CommentSimpleDTO(){}
    public CommentSimpleDTO(String text, BigInteger likeCounter, BigInteger dislikeCounter) {
        this.text = text;
        this.likeCounter = likeCounter;
        this.dislikeCounter = dislikeCounter;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public BigInteger getLikeCounter() {
        return likeCounter;
    }
    public void setLikeCounter(BigInteger likeCounter) {
        this.likeCounter = likeCounter;
    }
    public BigInteger getDislikeCounter() {
        return dislikeCounter;
    }
    public void setDislikeCounter(BigInteger dislikeCounter) {
        this.dislikeCounter = dislikeCounter;
    }
    @Override
    public String toString() {
        return "CommentSimpleDTO{" +
                "text='" + text + '\'' +
                ", likeCounter=" + likeCounter +
                ", dislikeCounter=" + dislikeCounter +
                '}';
    }
}
