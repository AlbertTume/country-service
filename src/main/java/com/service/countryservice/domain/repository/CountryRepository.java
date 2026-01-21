package com.service.countryservice.domain.repository;

import com.service.countryservice.domain.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {

    public List<Country> findAll();
    public Optional<Country> findByIsoCode2(String isoCode2);
    public List<Country> findByContinentId(Integer continentId);
    public boolean existsByIsoCode2(String isoCode2);

}
