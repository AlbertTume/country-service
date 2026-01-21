package com.service.countryservice.infrastructure.adapter.in.mapper;

import com.service.countryservice.application.dto.CountryDTO;
import com.service.countryservice.application.dto.CountryResponseDTO;
import com.service.countryservice.application.dto.CountryValidationDTO;
import com.service.countryservice.domain.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryMapper {

    /**
     * Convierte Modelo de dominio a CountryDTO (con continente aplanado)
     * @param domain Modelo de dominio
     * @return DTO con datos aplanados
     */
    public CountryDTO toDTO(Country domain) {
        if (domain == null) {
            return null;
        }

        return new CountryDTO(
                domain.getIsoCode2(),
                domain.getName(),
                domain.getContinent() != null ? domain.getContinent().getCode() : null,
                domain.getContinent() != null ? domain.getContinent().getName() : null
        );
    }

    /**
     * Convierte Modelo de Dominio a CountryResponseDTO (con continente anidado)
     * @param domain Modelo de Dominio
     * @return DTO con continente como objeto
     */
    public CountryResponseDTO toResponseDTO(Country domain) {
        if (domain == null) {
            return null;
        }

        return new CountryResponseDTO(
                domain.getIsoCode2(),
                domain.getName(),
                domain.getContinent()
        );
    }

    /**
     * Crea DTO de validación
     * @param isoCode2 Código ISO-2 consultado
     * @param exists Si el país existe o no
     * @return DTO de validación
     */
    public CountryValidationDTO toValidationDTO(String isoCode2, boolean exists) {
        return new CountryValidationDTO(isoCode2, exists);
    }

    /**
     * Convierte lista de Modelos de Dominio a lista de CountryResponseDTO
     * @param domainList Lista de modelos de Dominio
     * @return Lista de ResponseDTOs
     */
    public List<CountryDTO> toDTOList(List<Country> domainList) {
        if (domainList == null) {
            return null;
        }

        return domainList.stream()
                .map(this::toDTO)
                .toList();
    }

    /**
     * Convierte lista de Modelos de Dominio a lista de CountryResponseDTO
     * @param domainList Lista de modelos de Dominio
     * @return Lista de ResponseDTOs
     */
    public List<CountryResponseDTO> toResponseDTOList(List<Country> domainList) {
        if (domainList == null) {
            return null;
        }

        return domainList.stream()
                .map(this::toResponseDTO)
                .toList();
    }

}
