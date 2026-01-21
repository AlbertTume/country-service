package com.service.countryservice.application.port.in;

import com.service.countryservice.domain.model.Country;

/**
 * Puerto de entrada para buscar un país por su código ISO-2
 * EndPoint: [GET] /api/v1/countries/{isoCode}
 */
public interface FindCountryByCodeUseCase {

    /**
     * Busca un país por su código ISO-2
//   * @param isoCode2
     * @return País encontrado
//   * @throws si no existe - CountryNotFoundException
     */
    public Country findByIsoCode(String isoCode2);
}
