package com.my.manga.place.dev.dtos;
public class RolDTO {
    private String name;
    private String description;
    public RolDTO(){}
    public RolDTO(String name, String description) {
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
    @Override
    public String toString() {
        return "RolDTO{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
