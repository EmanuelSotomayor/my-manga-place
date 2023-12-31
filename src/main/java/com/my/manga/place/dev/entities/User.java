package com.my.manga.place.dev.entities;

import com.my.manga.place.dev.utils.IValidatorUtil;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "created_at")
    @Temporal(value = TemporalType.DATE)
    private Date createdAt;
    @Column(name = "deleted")
    private Boolean deleted;
    @OneToOne(targetEntity = Image.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "image_id")
    private Image image;
    @Transient
    IValidatorUtil iValidatorUtil;
    public User() {
    }
    public User(Long id, String name, String surname, String username, String email, String password, Date createdAt, Boolean deleted, Image image) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.deleted = deleted;
        this.image = image;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public void setIValidatorUtil(IValidatorUtil iValidatorUtil){
        this.iValidatorUtil = iValidatorUtil;
    }
    public IValidatorUtil getIValidatorUtil(){
        return this.iValidatorUtil = iValidatorUtil;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", deleted=" + deleted +
                ", image=" + image +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(createdAt, user.createdAt) && Objects.equals(deleted, user.deleted) && Objects.equals(image, user.image);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, username, email, password, createdAt, deleted, image);
    }
    @PrePersist
    public void init(){
        this.createdAt = new Date();
        this.deleted = Boolean.FALSE;
    }

}