package com.service.countryservice.application.port.in;

import com.service.countryservice.domain.model.Country;

import java.util.List;

/**
 * Puerto de entrada para obtener países por continente
 * EndPoint: [GET] /api/v1/countries/continent/{continentCode}
 */
public interface GetCountriesByContinentUseCase {

    /**
     * Obtiene todos los países de un continente específico
//   * @param continentCode
     * @return Lista de países del continente
     */
    public List<Country> getCountriesByContinent(String continentCode);
}
