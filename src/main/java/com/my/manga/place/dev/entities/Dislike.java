package com.my.manga.place.dev.entities;

import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Objects;
@Entity
@Table(name = "dislikes")
public class Dislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "counter")
    private BigInteger counter;
    public Dislike(){}
    public Dislike(Long id, BigInteger counter) {
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
        return "Dislike{" +
                "id=" + id +
                ", counter=" + counter +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dislike dislike = (Dislike) o;
        return Objects.equals(id, dislike.id) && Objects.equals(counter, dislike.counter);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, counter);
    }

}
