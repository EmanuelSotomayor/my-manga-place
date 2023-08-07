package com.my.manga.place.dev.services;

import com.my.manga.place.dev.dtos.RolDTO;
import com.my.manga.place.dev.requests.RolRequest;

import java.util.List;

public interface IRolService {
    public RolDTO saveRol(RolDTO rolDTO);
    public RolDTO findRolById(Long id);
    public List<RolDTO> findAllRoles();
    public void deleteRolById(Long id);
    public RolDTO updateRolById(Long id, RolRequest rolRequest);

}
