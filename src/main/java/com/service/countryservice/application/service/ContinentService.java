package com.service.countryservice.application.service;

import com.service.countryservice.domain.exception.ContinentNotFoundException;
import com.service.countryservice.domain.model.Continent;
import com.service.countryservice.domain.repository.ContinentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ContinentService {

    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public Continent findById(Integer id) {
        return continentRepository.findById(id)
                .orElseThrow(() -> new ContinentNotFoundException(id));
    }

    public Continent findByCode(String code) {
        return continentRepository.findByCode(code)
                .orElseThrow(() -> new ContinentNotFoundException(code));
    }

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

}
