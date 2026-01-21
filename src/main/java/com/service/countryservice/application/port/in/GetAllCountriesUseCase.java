package com.service.countryservice.application.port.in;

import com.service.countryservice.domain.model.Country;

import java.util.List;

/**
 * Puerto de entrada para obtener todos los países
 * EndPoint: [GET] /api/v1/countries
 */
public interface GetAllCountriesUseCase {
    /**
     * Obtiene todos los países registrados
     * @return Lista de todos los países
     */
    public List<Country> getAllCountries();
}
