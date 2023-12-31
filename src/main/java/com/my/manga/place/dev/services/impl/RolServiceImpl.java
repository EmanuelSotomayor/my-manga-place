package com.my.manga.place.dev.services.impl;

import com.my.manga.place.dev.dtos.RolDTO;
import com.my.manga.place.dev.entities.Rol;
import com.my.manga.place.dev.exceptions.RolException;
import com.my.manga.place.dev.repository.RolRepository;
import com.my.manga.place.dev.requests.RolRequest;
import com.my.manga.place.dev.services.IMessageService;
import com.my.manga.place.dev.services.IRolService;
import com.my.manga.place.dev.utils.builders.impl.RolDTOBuilder;
import com.my.manga.place.dev.utils.mappers.RolMapperUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RolServiceImpl implements IRolService {
    private final RolRepository rolRepository;
    private final IMessageService messageService;
    public RolServiceImpl(RolRepository rolRepository, IMessageService messageService){
        this.rolRepository = rolRepository;
        this.messageService = messageService;
    }
    @Override
    public RolDTO saveRol(RolDTO rolDTO) {
        Optional<Rol> rolExists = this.rolRepository.findByName(rolDTO.getName());
            if(rolExists.isPresent()){
                throw new RolException(this.messageService.getMessageProperty("rol.are.exists"));
            }
        Rol savedRol = this.rolRepository.save(RolMapperUtil.rolDTOtoRolEntity(rolDTO));
        return RolMapperUtil.rolEntityToRolDTO(savedRol);
    }
    @Override
    public RolDTO findRolById(Long id) {
        Optional<Rol> rolExists = this.rolRepository.findById(id);
        rolExists.orElseThrow(() -> new RolException(this.messageService.getMessageProperty("rol.not.found")));
        return RolMapperUtil.rolEntityToRolDTO(rolExists.get());
    }
    @Override
    public List<RolDTO> findAllRoles() {
        return RolMapperUtil.rolEntitiesToRolDTOs(this.rolRepository.findAll());
    }
    @Override
    public void deleteRolById(Long id) {
        Optional<Rol> rolExists = this.rolRepository.findById(id);
        rolExists.orElseThrow(() -> new RolException(this.messageService.getMessageProperty("rol.not.found")));
        this.rolRepository.deleteById(id);
    }
    @Override
    public RolDTO updateRolById(Long id, RolRequest rolRequest) {
        Optional<Rol> rolExists = this.rolRepository.findById(id);
        rolExists.orElseThrow(() -> new RolException(this.messageService.getMessageProperty("rol.not.found")));

        rolExists.get().setName(rolRequest.getName());
        rolExists.get().setDescription(rolRequest.getDescription());

        RolDTO rolDTO = RolDTOBuilder.builder()
                .name(rolRequest.getName())
                .description(rolRequest.getDescription())
                .build();

        this.rolRepository.save(rolExists.get());
        return rolDTO;
    }

}