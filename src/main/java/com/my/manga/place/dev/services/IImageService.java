package com.my.manga.place.dev.services;

import com.my.manga.place.dev.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
public interface IImageService {
    public Image saveImage(MultipartFile file) throws IOException;
    public void deleteImageById(Long id);
    public Image findImageById(Long id);
    public List<Image> findAllImages();
    public Image updateImageById(Long id, MultipartFile file) throws IOException;

}