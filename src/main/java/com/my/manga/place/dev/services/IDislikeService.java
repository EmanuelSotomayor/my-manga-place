package com.my.manga.place.dev.services;

import com.my.manga.place.dev.dtos.DislikeDTO;
import com.my.manga.place.dev.entities.Dislike;
import java.util.List;
public interface IDislikeService {
    public Dislike saveDislike(DislikeDTO dislikeDTO);
    public void deleteDislikeById(Long id);
    public Dislike updateDislikeById(Long id, DislikeDTO dislikeDTO);
    public Dislike findDislikeById(Long id);
    public List<Dislike> findAllDislikes();

}
