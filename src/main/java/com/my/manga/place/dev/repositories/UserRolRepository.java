package com.my.manga.place.dev.repositories;

import com.my.manga.place.dev.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRolRepository extends JpaRepository<UserRol, Long> {
}
