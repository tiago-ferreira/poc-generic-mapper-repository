package io.github.tiagoferreira.mapper;

import java.util.List;

public interface GenericMapper <ENTITY, DOMAIN>{

    ENTITY toEntity(DOMAIN domain);
    DOMAIN toDomain(ENTITY entity);
    List<ENTITY> toModels(List<DOMAIN> domain);
    List<DOMAIN> toDomains(List<ENTITY> entity);
}
