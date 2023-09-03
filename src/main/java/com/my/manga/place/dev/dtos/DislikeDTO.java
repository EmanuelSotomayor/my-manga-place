package com.my.manga.place.dev.dtos;

import java.math.BigInteger;
public class DislikeDTO {
    private BigInteger counter;
    public DislikeDTO(){}
    public DislikeDTO(BigInteger counter){
        this.counter = counter;
    }
    public BigInteger getCounter() {
        return counter;
    }
    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }

}
