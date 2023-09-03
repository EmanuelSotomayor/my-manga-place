package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.entities.Comment;
import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.entities.Like;

public interface ICommentBuilder extends IAbstractBuilder<Comment>{
    public ICommentBuilder id(Long id);
    public ICommentBuilder text(String text);
    public ICommentBuilder like(Like like);
    public ICommentBuilder dislike(Dislike dislike);
    public ICommentBuilder deleted(Boolean deleted);

}
