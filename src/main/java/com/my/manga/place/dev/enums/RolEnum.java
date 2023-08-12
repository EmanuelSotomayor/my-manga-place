package com.my.manga.place.dev.enums;

import com.my.manga.place.dev.entities.Rol;
public enum RolEnum {
    USER("USER", "Normal user"),
    ADMINISTRATOR("ADMINISTRATOR", "Administrator user");
    private String name;
    private String description;
    private RolEnum(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}