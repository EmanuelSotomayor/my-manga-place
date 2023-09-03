package com.my.manga.place.dev.entities;

import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;
    @OneToOne(targetEntity = Like.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "like_id")
    private Like like;
    @OneToOne(targetEntity = Dislike.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "dislike_id")
    private Dislike dislike;
    private Boolean deleted;
    public Comment() {
    }
    public Comment(Long id, String text, Like like, Dislike dislike, Boolean deleted) {
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
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", like=" + like +
                ", dislike=" + dislike +
                ", deleted=" + deleted +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(text, comment.text) && Objects.equals(like, comment.like) && Objects.equals(dislike, comment.dislike) && Objects.equals(deleted, comment.deleted);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, text, like, dislike, deleted);
    }

}