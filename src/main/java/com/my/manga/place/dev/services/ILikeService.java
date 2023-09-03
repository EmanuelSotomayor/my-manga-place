package com.my.manga.place.dev.services;

import com.my.manga.place.dev.dtos.LikeDTO;
import com.my.manga.place.dev.entities.Like;
import java.util.List;
public interface ILikeService {
    public Like saveLike(LikeDTO likeDTO);
    public void deleteLikeById(Long id);
    public Like updateLikeById(Long id, LikeDTO likeDTO);
    public Like findLikeById(Long id);
    public List<Like> findAllLikes();

}
