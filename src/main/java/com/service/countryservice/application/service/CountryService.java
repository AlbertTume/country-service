package com.service.countryservice.application.service;

import com.service.countryservice.application.port.in.FindCountryByCodeUseCase;
import com.service.countryservice.application.port.in.GetAllCountriesUseCase;
import com.service.countryservice.application.port.in.GetCountriesByContinentUseCase;
import com.service.countryservice.application.port.in.ValidateCountryExistsUseCase;
import com.service.countryservice.domain.exception.ContinentNotFoundException;
import com.service.countryservice.domain.exception.CountryNotFoundException;
import com.service.countryservice.domain.model.Continent;
import com.service.countryservice.domain.model.Country;
import com.service.countryservice.domain.repository.ContinentRepository;
import com.service.countryservice.domain.repository.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CountryService implements GetAllCountriesUseCase,
        FindCountryByCodeUseCase,
        GetCountriesByContinentUseCase,
        ValidateCountryExistsUseCase {

    private final CountryRepository countryRepository;
    private final ContinentRepository continentRepository;

    public CountryService(CountryRepository countryRepository,
                          ContinentRepository continentRepository) {
        this.countryRepository = countryRepository;
        this.continentRepository = continentRepository;
    }

    @Override
    public Country findByIsoCode(String isoCode2) {
        return countryRepository.findByIsoCode2(isoCode2)
                .orElseThrow(() -> new CountryNotFoundException(isoCode2));
    }

    @Override
    public boolean validateCountryExists(String isoCode2) {
        return countryRepository.existsByIsoCode2(isoCode2);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<Country> getCountriesByContinent(String continentCode) {
        Continent continent = continentRepository.findByCode(continentCode)
                .orElseThrow(() -> new ContinentNotFoundException(continentCode));

        return countryRepository.findByContinentId(continent.getId());
    }

}
