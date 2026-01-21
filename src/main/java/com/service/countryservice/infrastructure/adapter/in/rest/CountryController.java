package com.service.countryservice.infrastructure.adapter.in.rest;

import com.service.countryservice.application.dto.CountryDTO;
import com.service.countryservice.application.dto.CountryValidationDTO;
import com.service.countryservice.application.port.in.FindCountryByCodeUseCase;
import com.service.countryservice.application.port.in.GetAllCountriesUseCase;
import com.service.countryservice.application.port.in.GetCountriesByContinentUseCase;
import com.service.countryservice.application.port.in.ValidateCountryExistsUseCase;
import com.service.countryservice.infrastructure.adapter.in.mapper.CountryMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = "*")
public class CountryController {

    private final GetAllCountriesUseCase getAllCountriesUseCase;
    private final FindCountryByCodeUseCase findCountryByCodeUseCase;
    private final GetCountriesByContinentUseCase getCountriesByContinentUseCase;
    private final ValidateCountryExistsUseCase validateCountryExistsUseCase;
    private final CountryMapper mapper;

    public CountryController(GetAllCountriesUseCase getAllCountriesUseCase,
                             FindCountryByCodeUseCase findCountryByCodeUseCase,
                             GetCountriesByContinentUseCase getCountriesByContinentUseCase,
                             ValidateCountryExistsUseCase validateCountryExistsUseCase,
                             CountryMapper mapper) {
        this.getAllCountriesUseCase = getAllCountriesUseCase;
        this.findCountryByCodeUseCase = findCountryByCodeUseCase;
        this.getCountriesByContinentUseCase = getCountriesByContinentUseCase;
        this.validateCountryExistsUseCase = validateCountryExistsUseCase;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        var countries = getAllCountriesUseCase.getAllCountries();
        return ResponseEntity.ok(mapper.toDTOList(countries));
    }

    @GetMapping("/{isoCode}")
    public ResponseEntity<CountryDTO> getCountryByCode(@PathVariable String isoCode) {
        var country = findCountryByCodeUseCase.findByIsoCode(isoCode);
        return ResponseEntity.ok(mapper.toDTO(country));
    }

    @GetMapping("/continent/{continentCode}")
    public ResponseEntity<List<CountryDTO>> getCountriesByContinent(@PathVariable String continentCode) {
        var countries = getCountriesByContinentUseCase.getCountriesByContinent(continentCode);
        return ResponseEntity.ok(mapper.toDTOList(countries));
    }

    @GetMapping("/validate/{isoCode}")
    public ResponseEntity<CountryValidationDTO> validateCountryExists(@PathVariable String isoCode) {
        boolean exists = validateCountryExistsUseCase.validateCountryExists(isoCode);
        return ResponseEntity.ok(mapper.toValidationDTO(isoCode, exists));
    }

}
