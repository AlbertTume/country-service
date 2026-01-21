package com.service.countryservice.infrastructure.adapter.in.rest;

import com.service.countryservice.application.dto.ContinentDTO;
import com.service.countryservice.application.service.ContinentService;
import com.service.countryservice.infrastructure.adapter.in.mapper.ContinentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continents")
@CrossOrigin(origins = "*")
public class ContinentController {

    private final ContinentService continentService;
    private final ContinentMapper mapper;

    public ContinentController(ContinentService continentService, ContinentMapper mapper) {
        this.continentService = continentService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ContinentDTO>> getAllContinents() {
        var continents = continentService.getAllContinents();
        return ResponseEntity.ok(mapper.toDTOList(continents));
    }

    @GetMapping("/{code}")
    public ResponseEntity<ContinentDTO> getContinentByCode(@PathVariable String code) {
        var continent = continentService.findByCode(code);
        return ResponseEntity.ok(mapper.toDTO(continent));
    }

}
