package com.my.manga.place.dev.dtos;

import java.math.BigInteger;
public class LikeDTO {
    private BigInteger counter;
    public LikeDTO(){}
    public LikeDTO(BigInteger counter){
        this.counter = counter;
    }
    public BigInteger getCounter() {
        return counter;
    }
    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }

}
