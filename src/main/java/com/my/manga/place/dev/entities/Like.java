package com.my.manga.place.dev.entities;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Objects;
@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "counter")
    private BigInteger counter;
    public Like(){}
    public Like(Long id, BigInteger counter) {
        this.id = id;
        this.counter = counter;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigInteger getCounter() {
        return counter;
    }
    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }
    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", counter=" + counter +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(id, like.id) && Objects.equals(counter, like.counter);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, counter);
    }

}
