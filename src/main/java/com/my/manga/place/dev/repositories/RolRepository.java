package com.my.manga.place.dev.repositories;

import com.my.manga.place.dev.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    @Query(value = "SELECT r FROM Rol r WHERE r.name LIKE %:name%", nativeQuery = false)
    public Optional<Rol> findByName(@Param(value = "name") String name);

}