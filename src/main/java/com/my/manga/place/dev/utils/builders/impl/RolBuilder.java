package com.my.manga.place.dev.utils.builders.impl;

import com.my.manga.place.dev.entities.Rol;
import com.my.manga.place.dev.utils.builders.IRolBuilder;

public class RolBuilder implements IRolBuilder {
    private Rol rol;
    private RolBuilder(){
        this.rol = new Rol();
    }
    @Override
    public Rol build() {
        return this.rol;
    }
    @Override
    public IRolBuilder id(Long id) {
        this.rol.setId(id);
        return this;
    }
    @Override
    public IRolBuilder name(String name) {
        this.rol.setName(name);
        return this;
    }
    @Override
    public IRolBuilder description(String description) {
        this.rol.setDescription(description);
        return this;
    }
    public static RolBuilder builder(){
        return new RolBuilder();
    }

}