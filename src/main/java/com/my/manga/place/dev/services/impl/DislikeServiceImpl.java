package com.my.manga.place.dev.services.impl;

import com.my.manga.place.dev.dtos.DislikeDTO;
import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.repository.DislikeRepository;
import com.my.manga.place.dev.services.IDislikeService;
import com.my.manga.place.dev.services.IMessageService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class DislikeServiceImpl implements IDislikeService {
    private final IMessageService messageService;
    private final DislikeRepository dislikeRepository;
    public DislikeServiceImpl(IMessageService messageService, DislikeRepository dislikeRepository){
        this.messageService = messageService;
        this.dislikeRepository = dislikeRepository;
    }
    @Override
    public Dislike saveDislike(DislikeDTO dislikeDTO) {
        Dislike dislike = new Dislike();
        dislike.setCounter(dislikeDTO.getCounter());
        return this.dislikeRepository.save(dislike);
    }
    @Override
    public void deleteDislikeById(Long id) {
        Optional<Dislike> dislikeExists = this.dislikeRepository.findById(id);
        dislikeExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("dislike.not.found")));
        this.dislikeRepository.deleteById(id);
    }
    @Override
    public Dislike updateDislikeById(Long id, DislikeDTO dislikeDTO) {
        Optional<Dislike> dislikeExists = this.dislikeRepository.findById(id);
        dislikeExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("dislike.not.found")));
        dislikeExists.get().setCounter(dislikeDTO.getCounter());
        return this.dislikeRepository.save(dislikeExists.get());
    }
    @Override
    public Dislike findDislikeById(Long id) {
        Optional<Dislike> dislikeExists = this.dislikeRepository.findById(id);
        dislikeExists.orElseThrow(() -> new RuntimeException(this.messageService.getMessageProperty("dislike.not.found")));
        return dislikeExists.get();
    }
    @Override
    public List<Dislike> findAllDislikes() {
        return this.dislikeRepository.findAll();
    }

}