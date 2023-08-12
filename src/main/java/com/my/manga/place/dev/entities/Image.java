package com.my.manga.place.dev.entities;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "size")
    private BigInteger size;
    @Lob
    @Column(name = "hash", columnDefinition = "VARBINARY(MAX)")
    private byte[] hash;
    public Image(){}
    public Image(Long id, String title, BigInteger size, byte[] hash) {
        this.id = id;
        this.title = title;
        this.size = size;
        this.hash = hash;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public BigInteger getSize() {
        return size;
    }
    public void setSize(BigInteger size) {
        this.size = size;
    }
    public byte[] getHash() {
        return hash;
    }
    public void setHash(byte[] hash) {
        this.hash = hash;
    }
    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", hash=" + Arrays.toString(hash) +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(title, image.title) && Objects.equals(size, image.size) && Arrays.equals(hash, image.hash);
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, size);
        result = 31 * result + Arrays.hashCode(hash);
        return result;
    }

}