package com.my.manga.place.dev.repositories;

import com.my.manga.place.dev.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}