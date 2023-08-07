package com.my.manga.place.dev.utils;

import com.my.manga.place.dev.dtos.RolDTO;
import com.my.manga.place.dev.entities.Rol;

import java.util.List;
import java.util.stream.Collectors;

public class RolMapperUtil {
    public static Rol rolDTOtoRolEntity(RolDTO rolDTO){
        Rol rol = new Rol();
        rol.setId(rol.getId());
        rol.setName(rol.getName());
        rol.setDescription(rol.getDescription());
        return rol;
    }
    public static RolDTO rolEntityToRolDTO(Rol rol){
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());
        rolDTO.setDescription(rol.getDescription());
        return rolDTO;
    }

    public static List<RolDTO> rolEntitiesToRolDTOs(List<Rol> rols){
        return rols.stream()
                .map(rol -> rolEntityToRolDTO(rol))
                .collect(Collectors.toList());
    }
    public static List<Rol> rolDTOsToRolEntities(List<RolDTO> rolDtos){
        return rolDtos.stream()
                .map(rolDTO -> rolDTOtoRolEntity(rolDTO))
                .collect(Collectors.toList());
    }

}
