package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.dtos.RolDTO;

public interface IRolDTOBuilder extends IAbstractBuilder<RolDTO> {
    public IRolDTOBuilder name(String name);
    public IRolDTOBuilder description(String description);

}
