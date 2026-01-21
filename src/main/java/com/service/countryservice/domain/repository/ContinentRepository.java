package com.service.countryservice.domain.repository;

import com.service.countryservice.domain.model.Continent;

import java.util.List;
import java.util.Optional;

public interface ContinentRepository {

    public List<Continent> findAll();
    public Optional<Continent> findByCode(String code);
    public Optional<Continent> findById(Integer id);

}
