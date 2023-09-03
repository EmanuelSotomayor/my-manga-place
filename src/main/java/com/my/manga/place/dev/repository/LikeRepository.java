package com.my.manga.place.dev.repository;

import com.my.manga.place.dev.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
