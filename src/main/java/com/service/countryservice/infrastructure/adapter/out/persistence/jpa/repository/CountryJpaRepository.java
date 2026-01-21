package com.service.countryservice.infrastructure.adapter.out.persistence.jpa.repository;

import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryJpaRepository extends JpaRepository<CountryEntity, Integer> {

    public Optional<CountryEntity> findByIsoCode2(String isoCode2);
    public List<CountryEntity> findByContinentId(Integer continentId);
    public boolean existsByIsoCode2(String isoCode2);

}
