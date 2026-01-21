package com.service.countryservice.infrastructure.adapter.out.persistence.jpa.mapper;

import com.service.countryservice.domain.model.Continent;
import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.entity.ContinentEntity;
import org.springframework.stereotype.Component;

@Component
public class ContinentPersistenceMapper {

    /**
     * Convierte una entidad JPA a modelo de dominio
     * @param entity Entidad JPA de infraestructura
     * @return Modelo del dominio
     */
    public Continent toDomain(ContinentEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Continent(
                entity.getId(),
                entity.getCode(),
                entity.getName()
        );
    }

    /**
     * Convierte un modelo de dominio a una entidad JPA
     * @param domain Modelo de dominio
     * @return Entidad JPA de infraestructura
     */
    public ContinentEntity toEntity(Continent domain) {
        if (domain == null) {
            return null;
        }

        ContinentEntity entity = new ContinentEntity();
        entity.setId(domain.getId());
        entity.setCode(domain.getCode());
        entity.setName(domain.getName());

        return entity;
    }

}
