package com.service.countryservice.infrastructure.adapter.out.persistence.jpa.repository;

import com.service.countryservice.infrastructure.adapter.out.persistence.jpa.entity.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentJpaRepository extends JpaRepository<ContinentEntity, Integer> {

    public Optional<ContinentEntity> findByCode(String code);

}
