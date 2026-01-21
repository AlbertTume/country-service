package com.service.countryservice.infrastructure.adapter.out.persistence.jpa.adapter;

import com.service.countryservice.domain.model.Country;
import com.service.countryservice.domain.repository.CountryRepository;
import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.mapper.CountryPersistenceMapper;
import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.repository.CountryJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryRepositoryAdapter implements CountryRepository {

    private final CountryJpaRepository jpaRepository;
    private final CountryPersistenceMapper mapper;

    public CountryRepositoryAdapter(CountryJpaRepository jpaRepository,
                                    CountryPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Country> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByIsoCode2(String isoCode2){
        return jpaRepository.existsByIsoCode2(isoCode2);
    }

    @Override
    public List<Country> findByContinentId(Integer continentId) {
        return jpaRepository.findByContinentId(continentId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Country> findByIsoCode2(String isoCode2) {
        return jpaRepository.findByIsoCode2(isoCode2)
                .map(mapper::toDomain);
    }
}
