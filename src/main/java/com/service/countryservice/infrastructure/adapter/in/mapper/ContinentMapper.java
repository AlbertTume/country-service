package com.service.countryservice.infrastructure.adapter.in.mapper;

import com.service.countryservice.application.dto.ContinentDTO;
import com.service.countryservice.domain.model.Continent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContinentMapper {

    /**
     * Convierte modelo de dominio a DTO
     * @param domain Modelo de dominio
     * @return DTO para respuesta REST
     */
    public ContinentDTO toDTO(Continent domain) {
        if (domain == null) {
            return null;
        }

        return new ContinentDTO(
                domain.getCode(),
                domain.getName()
        );
    }

    /**
     * Convierte lista de modelos de dominio a lista de DTOs
     * @param domainList Lista de modelos de dominio
     * @return Lista de DTOs
     */
    public List<ContinentDTO> toDTOList(List<Continent> domainList) {
        if (domainList == null) {
            return List.of();
        }

        return domainList.stream()
                .map(this::toDTO)
                .toList();
    }

}

