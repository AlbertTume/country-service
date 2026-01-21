package com.service.countryservice.infrastructure.adapter.out.persistence.jpa.adapter;

import com.service.countryservice.domain.model.Continent;
import com.service.countryservice.domain.repository.ContinentRepository;
import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.mapper.ContinentPersistenceMapper;
import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.repository.ContinentJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ContinentRepositoryAdapter implements ContinentRepository {

    private final ContinentJpaRepository jpaRepository;
    private final ContinentPersistenceMapper mapper;

    public ContinentRepositoryAdapter(ContinentJpaRepository jpaRepository,
                                      ContinentPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Continent> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Continent> findByCode(String code) {
        return jpaRepository.findByCode(code)
                .map(mapper::toDomain);
    }

    @Override
    public List<Continent> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}
