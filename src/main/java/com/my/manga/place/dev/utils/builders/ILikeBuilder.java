package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.entities.Like;

import java.math.BigInteger;

public interface ILikeBuilder extends IAbstractBuilder<Like>{
    ILikeBuilder id(Long id);
    ILikeBuilder counter(BigInteger counter);
}
