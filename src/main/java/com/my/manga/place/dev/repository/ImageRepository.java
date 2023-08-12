package com.my.manga.place.dev.repository;

import com.my.manga.place.dev.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
