package com.my.manga.place.dev.repositories;

import com.my.manga.place.dev.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.email LIKE %:email%",
    nativeQuery = false)
    public Optional<User> findUserByEmail(@Param(value = "email") String email);

}
