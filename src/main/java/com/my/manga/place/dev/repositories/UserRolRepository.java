package com.my.manga.place.dev.repositories;

import com.my.manga.place.dev.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRolRepository extends JpaRepository<UserRol, Long> {
    @Query(value = "SELECT ur FROM UserRol ur " +
            "INNER JOIN User u ON u.id = ur.user.id" +
            "INNER JOIN Rol r ON r.id = ur.rol.id" +
            "WHERE u.email = :email" +
            "AND (r.name = :nameRol)", nativeQuery = false)
    public Optional<List<UserRol>> findByEmailAndRol(
            @Param(value = "email") String email,
            @Param(value = "nameRol") String nameRol);

}
