package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.dtos.CommentDTO;
import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.entities.Like;

public interface ICommentDTOBuilder extends IAbstractBuilder<CommentDTO>{
    public ICommentDTOBuilder id(Long id);
    public ICommentDTOBuilder text(String text);
    public ICommentDTOBuilder like(Like like);
    public ICommentDTOBuilder dislike(Dislike dislike);
    public ICommentDTOBuilder deleted(Boolean deleted);

}
