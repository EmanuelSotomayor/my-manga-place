package com.my.manga.place.dev.utils.builders;

import com.my.manga.place.dev.entities.Rol;

public interface IRolBuilder extends IAbstractBuilder<Rol>{
    public IRolBuilder id(Long id);
    public IRolBuilder name(String name);
    public IRolBuilder description(String description);

}
