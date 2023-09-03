package com.my.manga.place.dev.services.impl;

import com.my.manga.place.dev.dtos.LikeDTO;
import com.my.manga.place.dev.entities.Like;
import com.my.manga.place.dev.repository.LikeRepository;
import com.my.manga.place.dev.services.ILikeService;
import com.my.manga.place.dev.services.IMessageService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class LikeServiceImpl implements ILikeService {
    private final IMessageService messageService;
    private final ILikeService likeService;
    private final LikeRepository likeRepository;
    public LikeServiceImpl(IMessageService messageService, ILikeService likeService,
                           LikeRepository likeRepository){
        this.messageService = messageService;
        this.likeService = likeService;
        this.likeRepository = likeRepository;
    }
    @Override
    public Like saveLike(LikeDTO likeDTO) {
        Like like = new Like();
        like.setCounter(likeDTO.getCounter());
        return this.likeRepository.save(like);
    }
    @Override
    public void deleteLikeById(Long id) {
        Optional<Like> likeExists = this.likeRepository.findById(id);
        likeExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("like.not.found")));
        this.likeRepository.deleteById(id);
    }
    @Override
    public Like updateLikeById(Long id, LikeDTO likeDTO) {
        Optional<Like> likeExists = this.likeRepository.findById(id);
        likeExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("like.not.found")));
        likeExists.get().setCounter(likeDTO.getCounter());
        return this.likeRepository.save(likeExists.get());
    }
    @Override
    public Like findLikeById(Long id) {
        Optional<Like> likeExists = this.likeRepository.findById(id);
        likeExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("like.not.found")));
        return likeExists.get();
    }
    @Override
    public List<Like> findAllLikes() {
        return this.likeRepository.findAll();
    }

}