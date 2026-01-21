package com.service.countryservice.application.port.in;

/**
 * Puerto de entrada para validar la existencia de un país
 * EndPoint: [GET] /api/v1/countries/validate/{isoCode}
 * Usado por Currency Service pra validaciones
 */
public interface ValidateCountryExistsUseCase {

    /**
     * Valida si un país existe en el sistema
//   * @param isoCode2
     * @return true si el país existe, false en caso contrario
     */
    public boolean validateCountryExists(String isoCode2);
}
