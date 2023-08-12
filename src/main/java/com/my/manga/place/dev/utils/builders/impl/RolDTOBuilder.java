package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.dtos.RolDTO;
import com.my.manga.place.dev.utils.builders.IRolDTOBuilder;
public class RolDTOBuilder implements IRolDTOBuilder {
    private RolDTO rolDTO;
    private RolDTOBuilder(){
        this.rolDTO = new RolDTO();
    }
    @Override
    public RolDTO build() {
        return this.rolDTO;
    }
    @Override
    public IRolDTOBuilder name(String name) {
        this.rolDTO.setName(name);
        return this;
    }
    @Override
    public IRolDTOBuilder description(String description) {
        this.rolDTO.setDescription(description);
        return this;
    }
    public static RolDTOBuilder builder(){
        return new RolDTOBuilder();
    }

}