package io.github.tiagoferreira.repository;


import io.github.tiagoferreira.mapper.GenericMapper;
import org.apache.log4j.Logger;
import org.mapstruct.factory.Mappers;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericRepository <ENTITY, DOMAIN, KEY, MAPPER extends GenericMapper> {
    private final Logger logger = Logger.getLogger(this.getClass());

    private final Class<DOMAIN> typeOfDomain;

    private final Class<ENTITY> typeOfEntity;

    private final Class<KEY> typeOfKeyEntity;

    private final GenericMapper mapper;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    /////////////////////////////////////////////////////////////////////////////////

    @SuppressWarnings("unchecked")
    public GenericRepository() {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Type[] genericTypes = parameterizedType.getActualTypeArguments();

            this.logger.debug(genericTypes[0].getClass().getName());
            this.typeOfDomain = (Class<DOMAIN>) genericTypes[0];
            this.typeOfEntity = (Class<ENTITY>) genericTypes[1];
            this.typeOfKeyEntity = (Class<KEY>) genericTypes[2];
            this.mapper = Mappers.getMapper((Class<MAPPER>) genericTypes[3]);
        } catch (RuntimeException e) {
            this.logger.error(e.getMessage(), e);
            throw e;
        }

        if (this.logger.isInfoEnabled()) {
            this.logger.info(String.format("Creating a service with the bean [%s], entity [%s], key bean [%s] and key entity [%s].",
                    getTypeOfDomain(), getTypeOfEntity(), getMapper(), getTypeOfKeyEntity()));
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // ABSTRACT METHODS
    /////////////////////////////////////////////////////////////////////////////////

    protected abstract EntityManager getEntityManager();


    /////////////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    // ///////////////////////////////////////////////////////////////////////////////


    public DOMAIN save(DOMAIN domain) {
        ENTITY entity = (ENTITY) mapper.toEntity(domain);
        getEntityManager().persist(entity);
        return (DOMAIN) mapper.toDomain(entity);
    }

    public DOMAIN update(DOMAIN domain) {
        ENTITY entity = (ENTITY) mapper.toEntity(domain);
        entity = getEntityManager().merge(entity);
        return (DOMAIN) mapper.toDomain(entity);
    }

    public DOMAIN findById(KEY id) {
        ENTITY entity = (ENTITY) getEntityManager().find(this.typeOfEntity, id);
        return (DOMAIN) mapper.toDomain(entity);
    }

    public void delete(KEY id) {
        ENTITY entity = (ENTITY) getEntityManager().find(this.typeOfEntity, id);
        getEntityManager().remove(entity);
    }


    public final Class<DOMAIN> getTypeOfDomain() {
        return this.typeOfDomain;
    }

    public final Class<ENTITY> getTypeOfEntity() {
        return this.typeOfEntity;
    }

    public final Class<KEY> getTypeOfKeyEntity() {
        return this.typeOfKeyEntity;
    }

    public final GenericMapper getMapper() {
        return this.mapper;
    }
}