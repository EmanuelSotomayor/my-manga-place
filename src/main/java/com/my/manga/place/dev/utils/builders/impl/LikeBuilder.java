package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.entities.Like;
import com.my.manga.place.dev.utils.builders.ILikeBuilder;
import java.math.BigInteger;
public class LikeBuilder implements ILikeBuilder {
    private Like like;
    private LikeBuilder(){
        this.like = new Like();
    }
    @Override
    public Like build() {
        return this.like;
    }
    @Override
    public ILikeBuilder id(Long id) {
        this.like.setId(id);
        return this;
    }
    @Override
    public ILikeBuilder counter(BigInteger counter) {
        this.like.setCounter(counter);
        return this;
    }
    public static LikeBuilder builder(){
        return new LikeBuilder();
    }

}