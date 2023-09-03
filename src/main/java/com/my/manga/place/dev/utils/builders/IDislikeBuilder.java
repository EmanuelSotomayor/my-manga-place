package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.entities.Dislike;

import java.math.BigInteger;

public interface IDislikeBuilder extends IAbstractBuilder<Dislike>{
    IDislikeBuilder id(Long id);
    IDislikeBuilder counter(BigInteger counter);
}
