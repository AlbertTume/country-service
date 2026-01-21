package com.service.countryservice.application.dto;

import com.service.countryservice.domain.model.Continent;

public class CountryResponseDTO {

    private String isoCode2;
    private String name;
    private Continent continent;

    public CountryResponseDTO() { }

    public CountryResponseDTO(String isoCode2, String name, Continent continent) {
        this.isoCode2 = isoCode2;
        this.name = name;
        this.continent = continent;
    }

    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

}
