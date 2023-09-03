package com.my.manga.place.dev.entities;

import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "user_rol")
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(targetEntity = Rol.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "rol_id")
    private Rol rol;
    public UserRol(){}
    public UserRol(Long id, User user, Rol rol) {
        this.id = id;
        this.user = user;
        this.rol = rol;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    @Override
    public String toString() {
        return "UserRol{" +
                "id=" + id +
                ", user=" + user +
                ", rol=" + rol +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRol userRol = (UserRol) o;
        return Objects.equals(id, userRol.id) && Objects.equals(user, userRol.user) && Objects.equals(rol, userRol.rol);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, user, rol);
    }

}