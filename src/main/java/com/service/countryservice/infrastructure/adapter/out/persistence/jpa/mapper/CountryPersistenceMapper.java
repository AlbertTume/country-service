package com.service.countryservice.infrastructure.adapter.out.persistence.jpa.mapper;

import com.service.countryservice.domain.model.Country;
import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.entity.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryPersistenceMapper {

    private final ContinentPersistenceMapper continentMapper;

    public CountryPersistenceMapper(ContinentPersistenceMapper continentMapper) {
        this.continentMapper = continentMapper;
    }

    /**
     * Convierte una entidad JPA a Modelo de Dominio
     * @param entity Entidad JPA
     * @return Modelo de Dominio
     */
    public Country toDomain(CountryEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Country(
                entity.getIsoCode2(),
                entity.getName(),
                continentMapper.toDomain(entity.getContinent())
        );
    }

    /**
     * Convierte in Modelo de Dominio a Entidad JPA
     * @param domain Modelo de Dominio
     * @return Entidad JPA
     */
    public CountryEntity toEntity(Country domain) {
        if (domain == null) {
            return null;
        }

        CountryEntity entity = new CountryEntity();
        entity.setIsoCode2(domain.getIsoCode2());
        entity.setName(domain.getName());
        entity.setContinent(continentMapper.toEntity(domain.getContinent()));

        return entity;
    }

}
