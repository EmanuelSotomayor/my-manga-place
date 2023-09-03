package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.entities.Dislike;
import com.my.manga.place.dev.utils.builders.IDislikeBuilder;
import java.math.BigInteger;
public class DislikeBuilder implements IDislikeBuilder {
    private Dislike dislike;
    private DislikeBuilder(){
        this.dislike = new Dislike();
    }
    @Override
    public Dislike build() {
        return this.dislike;
    }
    @Override
    public IDislikeBuilder id(Long id) {
        this.dislike.setId(id);
        return this;
    }
    @Override
    public IDislikeBuilder counter(BigInteger counter) {
        this.dislike.setCounter(counter);
        return this;
    }
    public static DislikeBuilder builder(){
        return new DislikeBuilder();
    }

}