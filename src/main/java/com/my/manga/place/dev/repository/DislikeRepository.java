package com.my.manga.place.dev.repository;

import com.my.manga.place.dev.entities.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DislikeRepository extends JpaRepository<Dislike, Long> {
}
